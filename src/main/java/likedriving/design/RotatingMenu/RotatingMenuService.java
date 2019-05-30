package likedriving.design.RotatingMenu;

import java.io.IOException;
import java.util.Scanner;

public class RotatingMenuService {


    public static void main(String[] args) throws IOException {

        MenuItemStore menuItemStore = new MenuItemStore();
        CookedItemStore cookedItemStore = new CookedItemStore();
        SortedItemStore sortedItemStore = new SortedItemStore();
        boolean exitApp = false;

        System.out.println("Welcome to Rotating menu app ...!");

        while(true){
            System.out.println("Please select one of the following actions");
            System.out.println("1. Add a menu item");
            System.out.println("2. Add a cooked item");
            System.out.println("3. Sort the menu item list as per least recently cooked order");
            System.out.println("4. Display the sorted list");
            System.out.println("5. I am done for now, exit");

            Scanner sc = new Scanner(System.in);

            switch (sc.nextInt()){
                case 1:
                    System.out.println("Please enter a menu item to add: ");
                    String itemName = sc.next();
                    MenuItem menuItem = new MenuItem(itemName);
                    menuItemStore.add(menuItem);
                    menuItemStore.commit();
                    break;
                case 2:
                    System.out.println("Please chose a cooked item id from following list to add: ");
                   menuItemStore.display();
                    int itemId = sc.nextInt();
                    CookedItem cookedItem = new CookedItem(menuItemStore.get(itemId));
                    cookedItemStore.add(cookedItem);
                    cookedItemStore.commit();
                    break;
                case 3:
  /*                  System.out.println("Please enter a menu item to add: ");
                    String itemName = sc.next();
                    MenuItem menuItem = new MenuItem(itemName);
                    menuItemStore.add(menuItem);
                    menuItemStore.commit();*/
                    break;
                case 4:
/*                    System.out.println("Please enter a menu item to add: ");
                    String itemName = sc.next();
                    MenuItem menuItem = new MenuItem(itemName);
                    menuItemStore.add(menuItem);
                    menuItemStore.commit();*/
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

}
