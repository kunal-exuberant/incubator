package likedriving.design.RotatingMenu;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class MenuItem extends Object{
    private static int menuItemId = 0;
    private int id;
    private String name;

    public MenuItem(String name){
        this.id = ++menuItemId;
        this.name = name;
    }

    @Override
    public String toString(){
        return id +" "+ name;
    }
}
