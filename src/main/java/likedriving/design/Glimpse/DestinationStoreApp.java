package likedriving.design.Glimpse;

import likedriving.design.Glimpse.models.Destination;

import java.io.IOException;
import java.util.Scanner;

public class DestinationStoreApp {

    public static void main(String[] args) throws IOException {

        UserActivityWorkFlow userActivityWorkFlow = bootstrap();
        boolean exitApp = false;

        System.out.print("\nWelcome to Destination Store app ...!");

        while(true){
            System.out.println("\n\nPlease select one of the following actions");
            System.out.println("1. Add a destination");
            System.out.println("2. Show destination list");
            System.out.println("3. Search destination list");
            System.out.println("4. I am done for now, exit");

            System.out.print("\nYour choice: ");

            Scanner sc = new Scanner(System.in);
            if(!sc.hasNextInt()){
                System.out.print("\nInvalid input. Please enter a valid input");
                continue;
            }

            switch (sc.nextInt()){
                case 1:
                    userActivityWorkFlow.addDestination(sc);
                    break;
                case 2:
                    userActivityWorkFlow.showDestinationList();
                    break;
                case 3:
                    userActivityWorkFlow.searchDestinationList();
                    break;
                case 4:
                    System.out.println("Exiting the app ...");
                    exitApp = true;
                    break;
                default:
                    System.out.println("Invalid input. Please select a valid input");
            }

            if(exitApp){
                break;
            }
        }
    }

    private static UserActivityWorkFlow bootstrap() throws IOException{

        Destination.DESTINATION_ID =  RedisOperations.loadDestinationId();
        DestinationStore destinationStore = new DestinationStore();
        return new UserActivityWorkFlow(destinationStore, ESOperations.getClient());
    }
}
