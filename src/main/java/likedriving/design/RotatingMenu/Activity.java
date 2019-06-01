package likedriving.design.RotatingMenu;

import java.io.IOException;
import java.util.Scanner;

public interface Activity {
    void addMenuItem(Scanner sc) throws IOException;
    void addCookedItem(Scanner sc) throws IOException;
    void showMenuItemList() throws IOException;
    void showRecommendedMenu() throws IOException;
}
