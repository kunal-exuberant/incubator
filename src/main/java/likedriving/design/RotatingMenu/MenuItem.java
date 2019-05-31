package likedriving.design.RotatingMenu;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class MenuItem{
    private static int menuItemId = 0;
    private int id;
    private String name;

    public MenuItem(String name){
        this.id = ++menuItemId;
        this.name = name;
    }

    public static int getMenuItemId() {
        return menuItemId;
    }

    public static void setMenuItemId(int menuItemId){
        MenuItem.menuItemId = menuItemId;
    }

    @Override
    public String toString(){
        return id +" "+ name;
    }
}
