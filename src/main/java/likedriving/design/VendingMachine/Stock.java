package likedriving.design.VendingMachine;

import lombok.Builder;
import lombok.Data;

import java.util.Optional;

@Builder
@Data
public class Stock {
    private Item item;
    private int unitCount;
    private int unitPrice;

    public Stock(Item item, int unitCount, int unitPrice){
        this.item = item;
        this.unitCount = unitCount;
        this.unitPrice = unitPrice;
    }

    public Optional<Item> getItemWithPrice(int amount){
        if(this.getUnitPrice() == amount){
            return Optional.of(item);
        }
        return Optional.empty();
    }
}
