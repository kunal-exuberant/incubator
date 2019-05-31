package likedriving.design.RotatingMenu;

import lombok.Data;

@Data
public class CookedItem {

    private MenuItem menuItem;
    private long timestamp;

    public CookedItem(MenuItem menuItem){
        this.menuItem = menuItem;
        this.timestamp = System.currentTimeMillis();
    }

    public CookedItem(MenuItem menuItem, long timestamp){
        this.menuItem = menuItem;
        this.timestamp = timestamp;
    }

    @Override
    public String toString(){
        return menuItem.getId() +" "+ timestamp;
    }

    @Override
    public boolean equals(Object cookedItem){
        if(((CookedItem)cookedItem).getMenuItem().getId() == getMenuItem().getId()){
            return true;
        }
        return false;
    }
}
