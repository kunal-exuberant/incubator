package likedriving.design.RotatingMenu;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MenuItemStore extends FileActions implements MenuOperations{

    private static String fileUrl = "/Users/kunalsingh.k/likedriving/src/main/java/likedriving/design/RotatingMenu/data/menuItems.txt";
    private List<MenuItem> menuItemStore = new ArrayList<>();

    public MenuItemStore() throws IOException {
        super(fileUrl);
    }

    @Override
    public void add(Object item) {
        menuItemStore.add((MenuItem) item);
    }

    public MenuItem get(int itemId) throws IOException{
        return scan(itemId);
    }

    @Override
    public void display() throws IOException{
        System.out.println(read());
    }

    @Override
    public void commit() throws IOException{
        write();
    }

    public void write() throws IOException{
        FileWriter fileWriter = new FileWriter(new File(fileUrl), true);
        fileWriter.append(stringify(menuItemStore));
        fileWriter.close();
        menuItemStore.clear();
    }

    public String stringify(List<MenuItem> menuItems){
        String menuItemString = "";
        for(MenuItem menuItem: menuItems) {
            menuItemString += menuItem.toString()+"\n";
        }
        return menuItemString;
    }
}
