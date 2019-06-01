package likedriving.design.RotatingMenu;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class UserActivityWorkFlow implements Activity{

    private MenuItemStore menuItemStore;
    private CookedItemStore cookedItemStore;
    private SortedItemStore sortedItemStore ;

    public UserActivityWorkFlow(MenuItemStore menuItemStore, CookedItemStore cookedItemStore, SortedItemStore sortedItemStore){
        this.menuItemStore = menuItemStore;
        this.cookedItemStore = cookedItemStore;
        this.sortedItemStore = sortedItemStore;
    }

    @Override
    public void addMenuItem(Scanner sc) throws IOException {
        System.out.print("\nPlease enter a menu item to add: ");
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

        List<MenuItem> menuItemList = menuItemStore.populate();
        for(MenuItem menuItem: menuItemList) {
            if (menuItem.getName().equals((itemName))) {
                System.out.println(itemName + " is already present in our menu");
                toBeAdded = false;
                break;
            }
        }
        if(toBeAdded) {
            MenuItem menuItem = new MenuItem(itemName);
            menuItemStore.add(menuItem);
            menuItemStore.commit();
            System.out.print("\n"+menuItem.getName()+" added to the menu item list");
        }
    }

    @Override
    public void addCookedItem(Scanner sc) throws IOException{
        System.out.print("\nPlease choose a cooked item id from following list to add: ");
        menuItemStore.display();

        System.out.print("\nEnter cooked item id: ");

        if(!sc.hasNextInt()){
            System.out.print("\nInvalid input. Please enter a valid input");
        }else{
            int itemId = sc.nextInt();
            MenuItem menuItem = menuItemStore.get(itemId);
            if(menuItem != null) {
                CookedItem cookedItem = new CookedItem(menuItem);
                cookedItemStore.add(cookedItem);
                cookedItemStore.commit();
                System.out.print("\n"+menuItem.getName()+" added to the cooked item list");
            }
            else {
                System.out.print("\nThis menu item does not exist in our menu list");
            }
        }
    }

    @Override
    public void showMenuItemList() throws IOException{
        List<MenuItem> menuItemList = menuItemStore.populate();
        for(MenuItem menuItem: menuItemList){
            System.out.print("\n"+menuItem.getName());
        }
    }

    @Override
    public void showRecommendedMenu() throws IOException{
        sorting();
        System.out.print("\nRecommended menu for today (in sorted order): ");
        List<MenuItem> menuItemList = menuItemStore.populate();
        sortedItemStore.display1(menuItemList);
    }

    private void sorting() throws IOException{

        System.out.println("Sorting the menu item list as per least recently cooked order ... ");
        List<MenuItem> menuItemList = menuItemStore.populate();
        Stack<CookedItem> cookedItemStack = cookedItemStore.readCookedItem(menuItemList);
        while (!cookedItemStack.empty()){
            CookedItem cookedItem = cookedItemStack.pop();
            sortedItemStore.add(cookedItem);
        }
        for(CookedItem cookedItem: sortedItemStore.getSortedItemStore()){
            cookedItemStack.push(cookedItem);
        }
        sortedItemStore.getSortedItemStore().clear();
        while (!cookedItemStack.empty()){
            CookedItem cookedItem = cookedItemStack.pop();
            System.out.println(cookedItem);
            sortedItemStore.add(cookedItem);
        }
        sortedItemStore.commit();
    }
}
