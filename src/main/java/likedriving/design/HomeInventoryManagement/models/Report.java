package likedriving.design.HomeInventoryManagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data

/*
    * Number of days of stocks left per item
 */
public class Report {
    Map<Item, Integer> report = new HashMap<>();

    public Map<Item, Integer> generateReport(List<Item> items, Consumption consumption, Stock stock){
        for(Item item: items){
            report.put(item, stock.getStocksPerItem().get(item).getAmount() - consumption.getConsumptionPerConsumer().get(item).getAmount());
        }
        return report;
    }
}
