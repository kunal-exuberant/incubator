package likedriving.design.RotatingMenu;

import lombok.Data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
public class CookedItemStore extends FileActions implements MenuOperations{
    private static String fileUrl = "/Users/kunalsingh.k/likedriving/src/main/java/likedriving/design/RotatingMenu/data/cookedItems.txt";
    private List<CookedItem> cookedItemStore = new ArrayList<>();

    public CookedItemStore() throws IOException {
        super(fileUrl);
    }

    @Override
    public void add(Object item) {
        cookedItemStore.add((CookedItem) item);
    }

    @Override
    public void display() throws IOException{
        read();
    }

    @Override
    public void commit() throws IOException{
        write();
    }

    public void write() throws IOException{
        FileWriter fileWriter = new FileWriter(new File(fileUrl), true);
        fileWriter.append(stringify(cookedItemStore));
        fileWriter.close();
        cookedItemStore.clear();
    }

    public String stringify(List<CookedItem> cookedItems){
        String cookedItemString = "";
        for(CookedItem cookedItem: cookedItems) {
            cookedItemString += "\n"+cookedItem.toString();
        }
        return cookedItemString;
    }
}
