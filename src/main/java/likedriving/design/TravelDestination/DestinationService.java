package likedriving.design.TravelDestination;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import likedriving.design.TravelDestination.models.Destination;
import likedriving.design.TravelDestination.models.Duration;
import likedriving.design.TravelDestination.models.Type;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DestinationService {

    private DataStore dataStore;

    @Inject
    public DestinationService(DataStore dataStore){
        this.dataStore = dataStore;
    }

    public Optional<Destination> getDestination(String id){
        String destinationString = ESOperations.getDocumentById(id);
        Optional<likedriving.design.TravelDestination.models.Destination> optionalDestination = Optional.empty();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Destination destination = objectMapper.readValue(destinationString, Destination.class);
            optionalDestination = Optional.ofNullable(destination);
        }
        catch (IOException e){
            System.out.println(e);
        }
        return optionalDestination;
    }

    public List<Destination> searchDestination(String q){
        SearchResponse searchResponse = ESOperations.search_usingMatchQuery("name", q);
        String destinationString ="";
        List<Destination> destinationList = new ArrayList<>();
        if(searchResponse.status().toString().equals("OK")) {
            for (SearchHit hits : searchResponse.getHits()) {
                destinationString = hits.getSourceAsString();
                System.out.println(destinationString);
                destinationList.add(deserialize(destinationString));
            }
        }
        return destinationList;
    }

    public List<Destination> recommendDestination(Duration duration, List<Type> types){
        SearchResponse searchResponse = ESOperations.search_usingMatchQuery("name", "hills");
        String destinationString ="";
        List<Destination> destinationList = new ArrayList<>();
        if(searchResponse.status().toString().equals("OK")) {
            for (SearchHit hits : searchResponse.getHits()) {
                destinationString = hits.getSourceAsString();
                System.out.println(destinationString);
                destinationList.add(deserialize(destinationString));
            }
        }
        return destinationList;
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
