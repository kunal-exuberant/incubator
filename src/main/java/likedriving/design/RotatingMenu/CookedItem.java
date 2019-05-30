package likedriving.design.RotatingMenu;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CookedItem {

    private MenuItem menuItem;
    private long timestamp;

    public CookedItem(MenuItem menuItem){
        this.menuItem = menuItem;
        this.timestamp = System.currentTimeMillis();
    }

    @Override
    public String toString(){
        return menuItem.getId() +" "+ timestamp;
    }
}
