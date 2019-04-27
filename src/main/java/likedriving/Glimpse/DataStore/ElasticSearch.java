/*
package likedriving.Glimpse.DataStore;

import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.transport.client.PreBuiltTransportClient;


import java.net.UnknownHostException;

import static java.net.InetAddress.getByName;


public class ElasticSearch {

    Client client;

    public void getConnection() throws UnknownHostException {
        client = new PreBuiltTransportClient(
                Settings.builder().put("client.transport.sniff", true)
                        .put("cluster.name","elasticsearch").build())
                .addTransportAddress(new InetSocketTransportAddress(getByName("127.0.0.1"), 9300));
    }

    public void search(){
        client.prepareSearch("index1","index2")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.termQuery("multi", "test"))
                .setPostFilter(QueryBuilders.termQuery("multi", "test"))
                .setFrom(0).setSize(10).setExplain(true)
                .get();
    }

    public void searchFlavorTwo(){
        client.prepareSearch().get();
    }

    public void searchFlour3(){
        client.prepareSearch().setQuery(QueryBuilders.matchAllQuery());

        client.prepareSearch().setQuery(QueryBuilders.termQuery("abc",2));
    }

}
*/
