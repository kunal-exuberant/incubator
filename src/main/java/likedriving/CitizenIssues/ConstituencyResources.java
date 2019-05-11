package likedriving.CitizenIssues;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import likedriving.CitizenIssues.models.Constituency;
import likedriving.CitizenIssues.models.ElectoralIssue;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.junit.Test;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import static likedriving.CitizenIssues.ESResource.getClient;
import static likedriving.CitizenIssues.ESResource.putJsonDocument;

//@Api("Constituency")
@Path("/constituency")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ConstituencyResources {

    TransportClient client = null;

    @Inject
    public ConstituencyResources(TransportClient client){
        this.client = client;
    }

    @Path("/")
    @GET
    public void createIssueInConstituency() throws JsonProcessingException{
        System.out.println("I am inside createIssueInConstituency");
        ElectoralIssue issue = new ElectoralIssue();

        issue.setId(1);
        issue.setTitle("Bellandur Lake");
        issue.setDescription("In last few weeks this lake has started foaming again. No permanent solution has been arrived at in last 5 years.");

        Constituency constituency = new Constituency();
        constituency.setId(1);
        constituency.setIssue(Arrays.asList(issue));
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

    public void  inputDocument(Client client, Constituency constituency) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String constituencyStr = objectMapper.writeValueAsString(constituency);
        client.prepareIndex("test", "constituency")
                .setSource(constituency.getId(), constituency.getName(),  constituencyStr, constituency.getIssue().get(0).getTitle()).execute().actionGet();
    }

}
