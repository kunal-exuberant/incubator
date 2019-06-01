package likedriving.design.RotatingMenu;

import lombok.NoArgsConstructor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

@NoArgsConstructor
public class FileActions implements FileOperations {

    private String fileUrl;
    private File file = null;
    private Scanner sc;

    public FileActions(String fileUrl) throws IOException{
        this.fileUrl = fileUrl;
        this.file = new File(fileUrl);
    }

    @Override
    public Object read() throws IOException {
        this.sc = new Scanner(new File(fileUrl));
        String fileContent ="";

        while(sc.hasNext()){
            fileContent +=  sc.nextLine() + "\n";
        }
        return fileContent;
    }


    public List<CookedItem> read1(List<MenuItem> menuItems) throws IOException {
        this.sc = new Scanner(file);
        List<CookedItem> sortedItemList = new ArrayList<>();
        int cookedItemId = 0;
        long timestamp = 0;
        while (sc.hasNext()) {
            if(sc.hasNextInt()){
                cookedItemId = sc.nextInt();
            }
            else if(sc.hasNextLong()) {
                timestamp = sc.nextLong();

                if (cookedItemId != 0) {
                    MenuItem menuItem = null;
                    for (MenuItem mi : menuItems) {
                        if (mi.getId() == cookedItemId) {
                            menuItem = mi;
                        }
                    }
                    if (menuItem != null) {
                        sortedItemList.add(new CookedItem(menuItem, timestamp));
                        menuItem = null;
                    }
                }
                cookedItemId = 0;
            }
        }
        return sortedItemList;
    }

    public Stack<CookedItem> readCookedItem(List<MenuItem> menuItems) throws IOException {
        this.sc = new Scanner(file);
        Stack<CookedItem> cookedItemStack = new Stack<>();
        int cookedItemId = 0;
        long timestamp = 0;
        while (sc.hasNext()) {

            if(sc.hasNextInt()){
                cookedItemId = sc.nextInt();
            }
            else if(sc.hasNextLong()) {
                timestamp = sc.nextLong();
                if (cookedItemId != 0) {
                    MenuItem menuItem = null;
                    for (MenuItem mi : menuItems) {
                        if (mi.getId() == cookedItemId) {
                            menuItem = mi;
                        }
                    }
                    if (menuItem != null) {
                        cookedItemStack.push(new CookedItem(menuItem, timestamp));
                    }
                }
                cookedItemId = 0;
            }
        }
        return cookedItemStack;
    }

    @Override
    public void write(Object tuples) throws IOException{
        FileWriter fileWriter = new FileWriter(new File(fileUrl), true);
        fileWriter.append((String)tuples.toString());
        fileWriter.close();
    }

    @Override
    public MenuItem scan(int itemId) throws IOException {
        this.sc = new Scanner(file);
        String fileContent ="";

        while (sc.hasNext()) {
            if (sc.hasNextInt() && itemId == Integer.parseInt(sc.next())) {
                fileContent = sc.nextLine();
                return new MenuItem(itemId, fileContent);
            }else {
                sc.next();
            }
        }
        return null;
    }

    public List<MenuItem> populate() throws IOException {
        this.sc = new Scanner(file);
        int menuItemId = 0;
        String menuItemName = "";
        List<MenuItem> menuItems = new ArrayList<>();
        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                menuItemId = sc.nextInt();
            }else {
                menuItemName = sc.nextLine();
            }
            if(menuItemId != 0 && menuItemName != ""){
                menuItems.add(new MenuItem(menuItemId, menuItemName));
                menuItemId = 0;
                menuItemName = "";
            }
        }
        return menuItems;
    }

    @Override
    public int getLastMenuItemId() throws IOException {
        int itemId = 0;
        this.sc = new Scanner(new File(fileUrl));

        while (sc.hasNextLine()) {
            if (sc.hasNextInt()) {
                itemId = sc.nextInt();
            }else {
                if (sc.hasNext()) {
                    sc.next();
                }else {
                    break;
                }
            }
        }
        return itemId;
    }
}
