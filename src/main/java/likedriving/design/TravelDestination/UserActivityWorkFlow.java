package likedriving.design.TravelDestination;

import com.fasterxml.jackson.databind.ObjectMapper;
import likedriving.design.RotatingMenu.MenuItemValidator;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UserActivityWorkFlow implements Activity {

    private DestinationStore destinationStore;
    private Client client = null;

    public UserActivityWorkFlow(DestinationStore destinationStore, Client client){
        this.destinationStore = destinationStore;
        this.client = client;
    }

    @Override
    public void addDestination(Scanner sc) throws IOException {
        System.out.print("\nPlease enter a destination to add: ");
        sc.nextLine();
        String itemName = sc.nextLine();
        itemName = itemName.toLowerCase();

        boolean toBeAdded = true;

        List<String> validationErrors = MenuItemValidator.validate(itemName);
        if(validationErrors.size() != 0){
            for(String validationError : validationErrors){
                System.out.print("\n"+validationError);
            }
            toBeAdded = false;
        }

        SearchResponse searchResponse = ESOperations.search_usingMatchQuery("name", itemName);

        if(searchResponse.status().toString().equals("OK")){
            if(searchResponse.getHits().totalHits > 0) {
                System.out.println("Item Found");
                System.out.println(itemName + " is already present in our store");
                toBeAdded = false;
            }
        }
        if(toBeAdded) {
            Destination destination = new Destination(itemName);
            System.out.print("\nEnter a description:");
            destination.setDescription(sc.nextLine());
            System.out.print("\nPlease enter the city: ");

            String city = sc.nextLine();
            System.out.print("\nPlease enter the state: ");
            String state = sc.nextLine();

            Address address = new Address(city, state);
            destination.setAddress(address);

            destination.setDistance(120);

            ObjectMapper objectMapper = new ObjectMapper();
            String destinationString = objectMapper.writeValueAsString(destination);


            ESOperations.addDocument(destination.getName(), destinationString);
            RedisOperations.saveDestinationId();
            System.out.print("\n"+destination.getName()+" added to the destination list");
        }
    }

    @Override
    public void showDestinationList() throws IOException{
        SearchHits searchHits = ESOperations.getAllDocumentsAtIndex();
        if(searchHits.totalHits > 0) {
            for (SearchHit hits : searchHits.getHits()) {
                String destinationString = hits.getSourceAsString();
                System.out.println(destinationString);
                ObjectMapper objectMapper = new ObjectMapper();
                Destination destination = objectMapper.readValue(destinationString, Destination.class);
                System.out.println(destination);
  /*              if (destinationString.length() > 40) {
                    ObjectMapper objectMapper = new ObjectMapper();
                    Destination destination = objectMapper.readValue(destinationString, Destination.class);
                    System.out.println(destination);
                *//*for(Map.Entry<String, Object> map: hits.getSourceAsMap().entrySet()){
                    System.out.println(map.getKey() +" "+ map.getValue());
                }*//*
                    //System.out.print("\n" + destination.getId()+" "+destination.getName() +" "+destination.getDescription()+" "+destination.getAddress());
                }*/
            }
        }
        else {
            System.out.println("Destination list is empty");
        }
    }


    public void searchDestinationList() throws IOException{
        RedisOperations.load();
        SearchResponse searchResponse = ESOperations.search_usingMatchQuery("name", "innovative oak garden");
        SearchResponse searchResponse1 = ESOperations.search_usingMatchQuery("address.city", "bangalore");
        SearchResponse searchResponse2 = ESOperations.search_usingMatchQuery("id", "4");
        SearchResponse searchResponse3 = ESOperations.search_usingMatchQuery("address.state", "karnataka");
        if(searchResponse.status().toString().equals("OK")) {
            for (SearchHit hits : searchResponse.getHits()) {
                String destinationString = hits.getSourceAsString();
                System.out.println(destinationString);
  /*              if (destinationString.length() > 40) {
                    ObjectMapper objectMapper = new ObjectMapper();
                    Destination destination = objectMapper.readValue(destinationString, Destination.class);
                    System.out.println(destination);
                *//*for(Map.Entry<String, Object> map: hits.getSourceAsMap().entrySet()){
                    System.out.println(map.getKey() +" "+ map.getValue());
                }*//*
                    //System.out.print("\n" + destination.getId()+" "+destination.getName() +" "+destination.getDescription()+" "+destination.getAddress());
                }*/
            }
        }
        else {
            System.out.println("Destination list is empty");
        }
    }
}
