package likedriving.design.RotatingMenu;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class RotatingMenuService {


    public static void main(String[] args) throws IOException {

        MenuItemStore menuItemStore = new MenuItemStore();
        CookedItemStore cookedItemStore = new CookedItemStore();
        SortedItemStore sortedItemStore = new SortedItemStore();

        if(MenuItem.getMenuItemId() == 0){
            MenuItem.setMenuItemId(menuItemStore.generateMenuItemId());
        }
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
                    sc.nextLine();
                    String itemName = sc.nextLine();
                    MenuItem menuItem = new MenuItem(itemName);
                    menuItemStore.add(menuItem);
                    menuItemStore.commit();
                    break;
                case 2:
                    System.out.println("Please chose a cooked item id from following list to add: ");
                    menuItemStore.display();
                    int itemId = sc.nextInt();
                    menuItem = menuItemStore.get(itemId);
                    if(menuItem != null) {
                        CookedItem cookedItem = new CookedItem(menuItem);
                        cookedItemStore.add(cookedItem);
                        cookedItemStore.commit();
                    }
                    else {
                        System.out.println("This menu item does not exist in our menu list");
                    }
                    break;
                case 3:
                  System.out.println("sorting ... ");
                  List<MenuItem> menuItemList = menuItemStore.populate();
                  Stack<CookedItem> cookedItemStack = cookedItemStore.readCookedItem(menuItemList);
                  while (!cookedItemStack.empty()){
                      CookedItem cookedItem = cookedItemStack.pop();
                      System.out.println(cookedItem);
                      sortedItemStore.add(cookedItem);
                  }
                    sortedItemStore.commit();
                    break;
                case 4:
                  System.out.println("Printing the sorted menu suggestion for today: ");
                    menuItemList = menuItemStore.populate();
                    sortedItemStore.display1(menuItemList);
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
