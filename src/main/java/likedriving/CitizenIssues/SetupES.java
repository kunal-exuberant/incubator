package likedriving.CitizenIssues;


import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.refresh.RefreshRequest;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.IndicesAdminClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

public class SetupES {
    private static final Logger LOG = LoggerFactory.getLogger(SetupES.class);
    public static final String ERNEST_INDEX_NAME = "shop";
    public static final String HUGO_INDEX_NAME = "hugo_v2";
    public static final String TYPE_ELIGIBLE_SELLER = "eligibleSeller";
    public static final String TYPE_OFFER_PG_VIEW = "offerPGView";
    public static final String TYPE_OFFERS = "offers";
    public static final String TYPE_OFFER_PARTICIPANTS = "offerParticipants";
    public static final String DEFAULT = "_default_";
    public static final String PARENT_TYPE_OFFER_PG_VIEW = "{\"_parent\":{\"type\":\"offerPGView\"}}";
    public static final String PARENT_TYPE_PARTICIPANT = "{\"_parent\":{\"type\":\"offerParticipants\"}}";
    public static final String HUGO_READ = "HUGO_READ";
    public static final String HUGO_WRITE = "HUGO_WRITE";
    public static final String OFFER_PROGRESS = "offerProgress";
    public static final String PARTICIPANT_PROGRESS = "participantProgress";

    final private Client client;

    public SetupES(Client client) {
        this.client = client;
    }

    public void setupOfferES(boolean shouldForceCreate) throws IOException {
        IndicesAdminClient indices = client.admin().indices();
        //createIndex(ERNEST_INDEX_NAME, indices, false);
        //createIndex(HUGO_INDEX_NAME, indices, shouldForceCreate);
        createHugoAliases(indices, shouldForceCreate);
        createDefaultType(ERNEST_INDEX_NAME, indices, shouldForceCreate);
        createDefaultType(HUGO_INDEX_NAME, indices, shouldForceCreate);
        createOfferPGType(indices, shouldForceCreate);
        createChildType(indices, shouldForceCreate);
        createOffersType(indices, shouldForceCreate);
    }


    private void createIndex(String indexName, IndicesAdminClient indices, boolean shouldForceCreate) {
        boolean indexExist = indices.prepareExists(indexName).execute().actionGet().isExists();
        if (!indexExist || shouldForceCreate){
            indices.create(new CreateIndexRequest(indexName)).actionGet();
            indices.refresh(new RefreshRequest());
        }
    }

    private void createChildType(IndicesAdminClient indices, boolean shouldForceCreate) {
        boolean offerParticipantExists = indices.prepareTypesExists(ERNEST_INDEX_NAME).setTypes(TYPE_OFFER_PARTICIPANTS).execute().actionGet().isExists();
        boolean eligibleSellerExists = indices.prepareTypesExists(ERNEST_INDEX_NAME).setTypes(TYPE_ELIGIBLE_SELLER).execute().actionGet().isExists();
        boolean offerProgressExists =  indices.prepareTypesExists(ERNEST_INDEX_NAME).setTypes(OFFER_PROGRESS).execute().actionGet().isExists();
        boolean participantProgressExists =  indices.prepareTypesExists(ERNEST_INDEX_NAME).setTypes(PARTICIPANT_PROGRESS).execute().actionGet().isExists();
        if (!offerParticipantExists || shouldForceCreate)
            indices.preparePutMapping(ERNEST_INDEX_NAME).setType(TYPE_OFFER_PARTICIPANTS).setSource(PARENT_TYPE_OFFER_PG_VIEW).execute().actionGet();
        if (!eligibleSellerExists || shouldForceCreate)
            indices.preparePutMapping(ERNEST_INDEX_NAME).setType(TYPE_ELIGIBLE_SELLER).setSource(PARENT_TYPE_OFFER_PG_VIEW).execute().actionGet();
        if (!offerProgressExists || shouldForceCreate)
            indices.preparePutMapping(ERNEST_INDEX_NAME).setType(OFFER_PROGRESS).setSource(PARENT_TYPE_OFFER_PG_VIEW).execute().actionGet();
        if (!participantProgressExists || shouldForceCreate)
            indices.preparePutMapping(ERNEST_INDEX_NAME).setType(PARTICIPANT_PROGRESS).setSource(PARENT_TYPE_PARTICIPANT).execute().actionGet();
    }

    private void createOfferPGType(IndicesAdminClient indices, boolean shouldForceCreate) {
        boolean offerExists = indices.prepareTypesExists(ERNEST_INDEX_NAME).setTypes(TYPE_OFFER_PG_VIEW).execute().actionGet().isExists();
        if (!offerExists || shouldForceCreate)
            indices.preparePutMapping(ERNEST_INDEX_NAME).setType(TYPE_OFFER_PG_VIEW).setSource().execute().actionGet();
        indices.refresh(new RefreshRequest());
    }

    private void createOffersType(IndicesAdminClient indices, boolean shouldForceCreate) {
        boolean offerExists = indices.prepareTypesExists(HUGO_INDEX_NAME).setTypes(TYPE_OFFERS).execute().actionGet().isExists();
        if (!offerExists || shouldForceCreate)
            indices.preparePutMapping(HUGO_INDEX_NAME).setType(TYPE_OFFERS).setSource().execute().actionGet();
        indices.refresh(new RefreshRequest());
    }

    private void createHugoAliases(IndicesAdminClient indices, boolean shouldForceCreate) {
        if (!indices.prepareAliasesExist(HUGO_READ).execute().actionGet().exists() || shouldForceCreate)
            indices.prepareAliases().addAlias(HUGO_INDEX_NAME, HUGO_READ).execute().actionGet();
        if (!indices.prepareAliasesExist(HUGO_WRITE).execute().actionGet().exists() || shouldForceCreate)
            indices.prepareAliases().addAlias(HUGO_INDEX_NAME, HUGO_WRITE).execute().actionGet();
    }

    private void createDefaultType(String indexName, IndicesAdminClient indices, boolean shouldForceCreate) throws IOException {
        boolean defaultExists = indices.prepareTypesExists(indexName).setTypes(DEFAULT).execute().actionGet().isExists();
        if (!defaultExists || shouldForceCreate){
            XContentBuilder defaultMappingXContentBuilder = getDefaultMapping();
            indices.preparePutMapping(indexName).setType(DEFAULT).setSource(defaultMappingXContentBuilder).execute().actionGet();
        }
        indices.refresh(new RefreshRequest());
    }

    public XContentBuilder getDefaultMapping() throws IOException {
        XContentBuilder mappingRequestBuilder = null;
        mappingRequestBuilder = jsonBuilder().prettyPrint()
                .startObject()
                .startObject("_default_")
                .startArray("dynamic_templates")
                .startObject()
                .startObject("setNotAnalyzed")
                .field("match", "*")
                .field("match_mapping_type", "*")
                .startObject("mapping")
                .field("index", "not_analyzed")
                .endObject()
                .endObject()
                .endObject()
                .endArray()
                .endObject()
                .endObject();
        mappingRequestBuilder.humanReadable(true);
        LOG.info("Elasticsearch mapping json -  {}", mappingRequestBuilder.toString());
        return mappingRequestBuilder;
    }
}