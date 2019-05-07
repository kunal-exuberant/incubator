package likedriving.design.HomeInventoryManagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Consumers {

    private static int defaultConsumersPerItem = 1;
    Map<Item, Integer> consumers = new HashMap<>();

    public Integer getNumberOfConsumers(Item item){
        if(consumers.containsKey(item)) {
            return consumers.get(item);
        }
        return defaultConsumersPerItem;
    }
}
