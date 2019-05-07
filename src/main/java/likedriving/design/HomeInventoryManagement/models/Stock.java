package likedriving.design.HomeInventoryManagement.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Stock implements IStock {

    Map<Item, Quantity> stocksPerItem = new HashMap<>();
    Date inboardingDate = new Date();

    @Override
    public void addStock(Item item, Quantity quantity) {
        stocksPerItem.put(item, quantity);
    }

    @Override
    public Quantity getStock(Item item) {
       return stocksPerItem.get(item);
    }
}
