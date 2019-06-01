package likedriving.design.RotatingMenu;

import java.io.IOException;
import java.util.Scanner;

public class RotatingMenuService {

    public static void main(String[] args) throws IOException {

        UserActivityWorkFlow userActivityWorkFlow = bootstrap();
        boolean exitApp = false;

        System.out.print("\nWelcome to Rotating menu app ...!");

        while(true){
            System.out.println("\n\nPlease select one of the following actions");
            System.out.println("1. Add a menu item");
            System.out.println("2. Add a cooked item");
            System.out.println("3. Show menu item list");
            System.out.println("4. Show recommended menu");
            System.out.println("5. I am done for now, exit");

            System.out.print("\nYour choice: ");

            Scanner sc = new Scanner(System.in);
            if(!sc.hasNextInt()){
                System.out.print("\nInvalid input. Please enter a valid input");
                continue;
            }

            switch (sc.nextInt()){
                case 1:
                    userActivityWorkFlow.addMenuItem(sc);
                    break;
                case 2:
                    userActivityWorkFlow.addCookedItem(sc);
                    break;
                case 3:
                    userActivityWorkFlow.showMenuItemList();
                  break;
                case 4:
                    userActivityWorkFlow.showRecommendedMenu();
                    break;
                case 5:
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
        MenuItemStore menuItemStore = new MenuItemStore();
        CookedItemStore cookedItemStore = new CookedItemStore();
        SortedItemStore sortedItemStore = new SortedItemStore();

        if(MenuItem.getMenuItemId() == 0){
            MenuItem.setMenuItemId(menuItemStore.generateMenuItemId());
        }
        return new UserActivityWorkFlow(menuItemStore, cookedItemStore, sortedItemStore);
    }
}
