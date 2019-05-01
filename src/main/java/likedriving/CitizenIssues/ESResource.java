package likedriving.CitizenIssues;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.node.Node;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kunalsingh.k on 01/04/17.
 */


public class ESResource {

    private static Node node;
    private static Client client;


    public static TransportClient getClient() throws IOException {


            ElasticSearchConfig elasticSearchConfig = new ElasticSearchConfig();
            elasticSearchConfig.clusterName = "elasticsearch_kunalsingh.k";
            elasticSearchConfig.host = "localhost";
            elasticSearchConfig.port = 9200;

        Settings settings = Settings.builder()
                .put("cluster.name", "elasticsearch_kunalsingh.k").build();
        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9200))
                .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));

        return client;
    }


    public static GetResponse esDeepSearch(Client client, String id){
        GetResponse getResponse = client.prepareGet("test", "constituency", id).execute().actionGet();
        Map<String, Object> source = getResponse.getSource();
        System.out.println("------------------------------");
        System.out.println("Index: " + getResponse.getIndex());
        System.out.println("Type: " + getResponse.getType());
        System.out.println("Id: " + getResponse.getId());
        System.out.println("Version: " + getResponse.getVersion());
        System.out.println(source);
        System.out.println("------------------------------");
        return getResponse;
    }



    public static void deleteDocument(Client client, String index, String type, String id){
        DeleteResponse response = client.prepareDelete(index, type, id).execute().actionGet();
        System.out.println("Information on the deleted document:");
        System.out.println("Index: " + response.getIndex());
        System.out.println("Type: " + response.getType());
        System.out.println("Id: " + response.getId());
        System.out.println("Version: " + response.getVersion());
    }

    public static List<Object> searchDocument(Client client, String index, String type,
                                      String field, String value){

        List<Object> resultResponse = new ArrayList<Object>();
        Map<String, String> map = new HashMap<String, String>();
        map.put(field, value);
        SearchResponse response = client.prepareSearch(index)
                .setTypes(type)
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(
                        QueryBuilders.queryStringQuery(value)
                                .field("shopType")
                                .field("description")
                                .field("shopName")
                                .field("landmark")
                                .field("address")
                                .field("area")
                                .field("location")
                )
                //.setPostFilter(QueryBuilders.rangeQuery("age").from(12).to(18))     // Filter
                .setFrom(0).setSize(60).setExplain(true)
                .get();
        SearchHit[] results = response.getHits().getHits();
        System.out.println("Current results: " + results.length);
        for (SearchHit hit : results) {
            System.out.println("------------------------------");
            Map<String,Object> result = hit.getSourceAsMap();
            resultResponse.add(result);
            System.out.println(result);
        }
        return resultResponse;
    }

    public static Map<String, Object> putJsonDocument(int shopId, String imageName, String shopName, String mobile, String alternateMobile, String thirdContact,
            String shopType, String address, String landmark, String area, String description, String email){
            Map<String, Object> jsonDocument = new HashMap<String, Object>();
            jsonDocument.put("shopId", shopId);
            jsonDocument.put("imageName", imageName);
            jsonDocument.put("shopName", shopName);
            jsonDocument.put("mobile", mobile);
            jsonDocument.put("alternateMobile", alternateMobile);
            jsonDocument.put("thirdContact", thirdContact);
            jsonDocument.put("shopType", shopType);
            jsonDocument.put("address", address);
            jsonDocument.put("landmark", landmark);
            jsonDocument.put("area", area);
            jsonDocument.put("description", description);
            jsonDocument.put("email", email);
            return jsonDocument;
    }

    public static Map<String, Object> putJsonDocument(int id, String name){
        Map<String, Object> jsonDocument = new HashMap<String, Object>();
        jsonDocument.put("id", id);
        jsonDocument.put("name", name);
        return jsonDocument;
    }



    public static void main(String[] args) {
        try {
            //new SetupES(getClient()).setupOfferES(true);
            ESResource esResource = new ESResource();
            TransportClient client = getClient();
            //esResource.esDeepSearch(client);


            //deleteDocument(client, "kodcucom", "article", "1");
            // updateDocument(client, "kodcucom", "article", "1", "tags", "big-data");
            //searchDocument(client, "shop", "shop", "shopType", "Parlor");
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}