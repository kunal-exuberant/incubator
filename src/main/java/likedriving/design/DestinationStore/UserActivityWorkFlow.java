package likedriving.design.DestinationStore;

import likedriving.design.RotatingMenu.*;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UserActivityWorkFlow implements Activity{

    private DestinationStore destinationStore;

    public UserActivityWorkFlow(DestinationStore destinationStore){
        this.destinationStore = destinationStore;
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

        RedisOperations.load();
        List<Destination> destinations = DestinationStore.destinationStore;
        for(Destination destination: destinations) {
            if (destination.getName().equals((itemName))) {
                System.out.println(itemName + " is already present in our store");
                toBeAdded = false;
                break;
            }
        }
        if(toBeAdded) {
            Destination destination = new Destination(itemName);
            System.out.print("\nEnter a description:");
            destination.setDescription(sc.nextLine());
            destinationStore.destinationStore.add(destination);
            RedisOperations.commit();
            System.out.print("\n"+destination.getName()+" added to the menu item list");
        }
    }

    @Override
    public void showDestinationList() throws IOException{
        RedisOperations.load();
        List<Destination> destinations = destinationStore.destinationStore;
        if(destinations.size() > 0) {
            for (Destination destination : destinations) {
                System.out.print("\n" + destination.getId()+" "+destination.getName() +" "+destination.getDescription()+" "+destination.getAddress());
            }
        }
        else {
            System.out.println("Destination list is empty");
        }
    }
}
