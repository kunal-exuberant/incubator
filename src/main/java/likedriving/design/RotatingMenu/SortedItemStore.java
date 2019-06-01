package likedriving.design.RotatingMenu;

import lombok.Data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class SortedItemStore extends FileActions implements MenuOperations{

    private static String fileUrl = "/Users/kunalsingh.k/likedriving/src/main/java/likedriving/design/RotatingMenu/data/sortedItems.txt";
    private List<CookedItem> sortedItemStore = new ArrayList<>();

    public SortedItemStore() throws IOException {
        super(fileUrl);
    }

    @Override
    public void add(Object item) {
        if(!sortedItemStore.contains((CookedItem)item)) {
            sortedItemStore.add((CookedItem) item);
        }
    }

    @Override
    public void display() throws IOException {
        System.out.println(read());
    }

    public void display1(List<MenuItem> menuItems) throws IOException {
        List<CookedItem> sortedItemList = read1(menuItems);

        String pattern = "dd MMM";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        for(CookedItem cookedItem: sortedItemList) {
            System.out.print("\n"+cookedItem.getMenuItem().getName()+" last cooked on "+ simpleDateFormat.format(new Date(cookedItem.getTimestamp())));
        }
    }

    @Override
    public void commit() throws IOException {
        write();
    }

    public void write() throws IOException{
        FileWriter fileWriter = new FileWriter(new File(fileUrl));
        fileWriter.write(stringify(sortedItemStore));
        fileWriter.close();
        sortedItemStore.clear();
    }

    public String stringify(List<CookedItem> cookedItems){
        String cookedItemString = "";
        for(CookedItem cookedItem: cookedItems) {
            cookedItemString += cookedItem.toString()+"\n";
        }
        return cookedItemString;
    }
}
