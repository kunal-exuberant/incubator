package likedriving.design.TravelDestination;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.Optional;

@Path("/destination")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TravelDestinationResource {

    public TravelDestinationResource(){
        ESOperations.getClient();
    }

    @Path("/")
    @GET
    public Destination getDestinationInfo(@QueryParam("id") String id) throws JsonProcessingException{
        System.out.println("I am inside get destination info");

        String destinationString = ESOperations.getDocumentById(id);
        Optional<Destination> optionalDestination = Optional.empty();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Destination destination = objectMapper.readValue(destinationString, Destination.class);
            optionalDestination = Optional.ofNullable(destination);
        }
        catch (IOException e){
            System.out.println(e);
        }
        return optionalDestination.get();
    }

    @Path("/search/{q}")
    @GET
    public Destination searchDestination(@PathParam("q") String q) throws JsonProcessingException{
        System.out.println("I am inside get destination search "+q);

        SearchResponse searchResponse = ESOperations.search_usingMatchQuery("id", q);
        String destinationString ="";
        if(searchResponse.status().toString().equals("OK")) {
            for (SearchHit hits : searchResponse.getHits()) {
                destinationString = hits.getSourceAsString();
                System.out.println(destinationString);
            }
        }

        return deserialize(destinationString);
    }

    public Destination deserialize(String destinationString){
        Destination destination = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            destination = objectMapper.readValue(destinationString, Destination.class);
        }
        catch (Exception e){
            System.out.println(e);
        }
        return destination;
    }
}
