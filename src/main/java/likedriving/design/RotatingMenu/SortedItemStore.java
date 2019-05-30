package likedriving.design.RotatingMenu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SortedItemStore extends FileActions{

    private static String fileUrl = "/Users/kunalsingh.k/likedriving/src/main/java/likedriving/design/RotatingMenu/data/sortedItems.txt";
    private List<CookedItem> sortedItemStore = new ArrayList<>();

    public SortedItemStore() throws IOException {
        super(fileUrl);
    }
}
