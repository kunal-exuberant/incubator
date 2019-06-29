package likedriving.design.TravelDestination;

import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequestBuilder;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequest;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.indices.InvalidIndexNameException;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

public class ESOperations {

    private static Client client = null;
    private static String indexName = "test_index1";
    private static String type = "details";
    private static QueryBuilder queryBuilder;
    private static QueryBuilder builder;

    public static Client getClient() {
        String clusterName = "elasticsearch_kunalsingh.k";
        String host = "localhost";
        Integer port = 9300;

        Settings settings = Settings.builder()
                .put("cluster.name", clusterName).build();

        try {
            if(client != null){
                return client;
            }
            client = new PreBuiltTransportClient(settings)
                    .addTransportAddress(new TransportAddress(InetAddress.getByName(host), port));
        }
        catch(IOException e){
            System.out.println("Unable to get ES client "+e);
        }
        return client;
    }

    public static void addBulkDocuments(List<Destination> destinationList) {
        System.out.println("Initializing bulk request ...");
        try {

            BulkRequestBuilder bulkRequestBuilder = client.prepareBulk();

                    for(Destination destination: destinationList) {
                        IndexRequest indexRequest = client.prepareIndex(indexName, type, String.valueOf(destination.getId()))
                                .setSource(jsonBuilder().startObject()
                                        .field("id", destination.getId())
                                        .field("name", destination.getName())
                                        .field("description", destination.getDescription())
                                        .field("city", destination.getAddress().getCity())
                                        .field("state", destination.getAddress().getState())
                                        .endObject()).request();
                        bulkRequestBuilder.add(indexRequest);
                    }
            BulkResponse response = bulkRequestBuilder.get();

            System.out.println(response.status());
        }
        catch(IOException e){
            System.out.println("Unable to insert data in ES "+e);
        }
    }

    public static void addDocument(String id, String serializedObject) {
        try {
            IndexResponse response =
                    client
                    .prepareIndex(indexName, type, id)
                    .setSource(serializedObject, XContentType.JSON)
                    .get();
            System.out.println(response.status());
        }
        catch(Exception e){
            System.out.println("Unable to insert data in ES "+e);
        }
    }

    public static SearchHits getAllDocumentsAtIndex(){
        SearchRequest searchRequest = new SearchRequest(indexName);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.size(500);
        searchRequest.source(searchSourceBuilder);
        System.out.println(client.search(searchRequest));
        ActionFuture<SearchResponse> searchResponseActionFuture = client.search(searchRequest);
        try {
            SearchResponse searchResponse = searchResponseActionFuture.get();
            System.out.println();
            return searchResponse.getHits();
        }catch (InterruptedException | ExecutionException e){
            System.out.println(e);
        }
        return null;
    }

    public static String getDocumentById(String id){

        GetResponse response = client.prepareGet(indexName, type, id).execute().actionGet();
        System.out.println(response.toString());
        return response.getSourceAsString();
    }

    public static SearchResponse search_usingMatchQuery(String field, String value){
        System.out.println("Searching ES using match query...");
        queryBuilder = QueryBuilders.matchQuery(field,value);
        SearchResponse response = client
                .prepareSearch(indexName)
                .setQuery(queryBuilder).get();
        System.out.println(response);
        return response;
    }

    public static SearchResponse search_usingTermQuery(String field, String value){
        System.out.println("Searching ES using term query...");
        queryBuilder = QueryBuilders.termQuery(field,value);
        SearchResponse response = client
                .prepareSearch(indexName)
                .setQuery(queryBuilder).get();
        System.out.println(response);
        return response;
    }

    private static void createIndex(){
        System.out.println("Running ES query ...");

        try {
            IndicesExistsRequestBuilder indicesExistsRequestBuilder = client.admin().indices().prepareExists(indexName);
            ActionFuture<IndicesExistsResponse> future =  client.admin().indices().exists(indicesExistsRequestBuilder.request());

            if(future.get().isExists()){
                System.out.println("Index already exists");
            }else{
                System.out.println("Creating new index "+indexName);
                CreateIndexRequest createIndexRequest = client.admin().indices().prepareCreate(indexName).request();

                XContentBuilder xContentBuilder = XContentFactory.contentBuilder(XContentType.JSON);

                AcknowledgedResponse response = client.admin().indices()
                        .preparePutMapping(indexName)
                        .setType(type)
                        .setSource(xContentBuilder).execute().actionGet();

                //createIndexRequest.mapping(type, xContentBuilder.field("name", "String")
                                        //                        .field("description", "String")
                                          //                      .field("address",""));



/*                CreateIndexResponse response = createIndexRequest
                        .mapping(xContentBuilder
                                .field("name", String.valueOf("abc"))
                                .field("description", ")
                        )*/
            }
        }

        catch (IOException e){
            System.out.println("Unable to check if index exists "+e);
        }
        catch (InterruptedException | ExecutionException e){
            System.out.println("Unable to check if index exists "+e);
        }
        catch (InvalidIndexNameException e){
            System.out.println("Invalid index name exception "+e);
        }
        System.out.println("Final statement ...");
    }

    public static void main(String[] args) {
        getClient();
        createIndex();
        Destination destination = new Destination(100,"Munnar",Type.HILL_STATION,400,"Munnar is beautiful hill station with huge valley view", new Address("Munnar City", "Karnataka"));
        //addDocument(destination);
        addBulkDocuments(Arrays.asList(destination));
        //fetchDocument();
        //search_usingTermQuery();
        //search_usingMatchQuery();
    }

    @Test
    public void mappingTest() throws IOException{
        PutMappingRequest putMappingRequest = new PutMappingRequest();
        XContentBuilder builder = XContentFactory.jsonBuilder();

        builder.startObject()
                .startObject("properties")
                .startObject("destination")
                .field("type", "text")
                .endObject()
                .endObject()
                .endObject();
        putMappingRequest.source(builder);

        putMappingRequest.source(

                "{\n" +
                        "  \"properties\": {\n" +
                        "    \"destination\": {\n" +
                        "      \"type\": \"text\"\n" +
                        "    }\n" +
                        "  }\n" +
                        "}",
                XContentType.JSON);
    }

    @Test
    public void test() throws IOException{
        getClient();

        Map<String, Object> destination = new HashMap<>();
        destination.put("type", "object");

        Map<String, Object> address = new HashMap<>();
        address.put("type","object");


        Map<String, Object> properties = new HashMap<>();
        properties.put("destination", destination);
        properties.put("address", address);


        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("properties", properties);


        CreateIndexRequest createIndexRequest
                = client.admin()
                .indices()
                .prepareCreate("test_index1")
                .request();

        createIndexRequest.mapping(type, jsonMap);
        CreateIndexResponse createIndexResponse = client.admin().indices().create(createIndexRequest).actionGet();

        if(createIndexResponse.isAcknowledged()){
            System.out.println("Index created");
        }
        else {
            System.out.println("Index could not be created");
        }
    }
}