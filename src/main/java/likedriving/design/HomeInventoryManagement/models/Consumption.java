package likedriving.design.HomeInventoryManagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Consumption implements IConsumption {

    Map<Item, Quantity> consumptionPerConsumer = new HashMap<>();
    Consumers consumers = new Consumers();

    @Override
    public Quantity getConsumption(Item item) {
        return consumptionPerConsumer.get(item);
    }
}
