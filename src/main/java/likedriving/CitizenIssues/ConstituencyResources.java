package likedriving.CitizenIssues;

import likedriving.CitizenIssues.models.Constituency;
import likedriving.CitizenIssues.models.ElectoralIssue;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.junit.Test;

import javax.ws.rs.Path;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import static likedriving.CitizenIssues.ESResource.getClient;
import static likedriving.CitizenIssues.ESResource.putJsonDocument;

@Path("/constituency")
public class ConstituencyResources {

    TransportClient client = null;

    @Test
    public void createIssueInConstituency() {

        ElectoralIssue issue = new ElectoralIssue();

        issue.setId(1);
        issue.setTitle("Bellandur Lake");
        issue.setDescription("In last few weeks this lake has started foaming again. No permanent solution has been arrived at in last 5 years.");

        Constituency constituency = new Constituency();
        constituency.setId(1);
        constituency.setIssue(Arrays.asList(issue));

        try {
            client = getClient();
        } catch (IOException e) {
            e.printStackTrace();
        }
        inputDocument(client, constituency);
    }

    @Test
    public void getConstituencyInfo() throws IOException {
        client = getClient();
        ESResource.esDeepSearch(client, "2");
    }

    @Test
    public void putConstituencyInfo() throws IOException {

        File constituencyDataFile = new File("/Users/kunalsingh.k/likedriving/src/main/java/likedriving/CitizenIssues/data/States.yml");
        Scanner scanner = new Scanner(constituencyDataFile);
        client = getClient();
        int id = 1;
        while (scanner.hasNext()) {
            try {
                inputDocument(client, id, scanner.next());
                id++;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void inputDocument(Client client, int id, String name){
        client.prepareIndex("test", "constituency")
                .setSource(putJsonDocument(id, name)).execute().actionGet();
    }

    public void inputDocument(Client client, Constituency constituency){
        client.prepareIndex("test", "constituency")
                .setSource(constituency.getId(), constituency.getName(),
                        constituency.getIssue().get(0).getTitle(), constituency.getIssue().get(0).getTitle()).execute().actionGet();
    }

}
