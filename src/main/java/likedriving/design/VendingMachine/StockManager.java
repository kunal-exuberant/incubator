package likedriving.design.VendingMachine;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Builder
@Data
@Slf4j
public class StockManager {

    int stockCapacity;
    private Map<Item, Integer> itemsStocks;

    public StockManager(int stockCapacity, Map<Item, Integer> itemsStocks){
        this.stockCapacity = stockCapacity;
        this.itemsStocks = itemsStocks;
    }

    public void stockOnboarding(List<Stock> stocks) {
        stocks.forEach(stock -> {
            if(itemsStocks.size() < stockCapacity) {
                log.info("On boarding the stocks for, item {}", stock.getItem().getItemName());
                if(itemsStocks.containsKey(stock.getItem())) {
                    itemsStocks.put(stock.getItem(), stock.getUnitCount() + itemsStocks.get(stock.getItem()));
                }
                else{
                    itemsStocks.put(stock.getItem(), stock.getUnitCount());
                }
            }
            else{
                try {
                    throw new StockLimitExceededException("Stock is already upto the maximum limit");
                } catch (StockLimitExceededException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void vendStock(Item item) throws StockLimitExceededException {
        log.info("Reducing the stock for item {}", item.getItemName());
        if(itemsStocks.containsKey(item)) {
            itemsStocks.put(item, itemsStocks.get(item) - 1);
            return;
        }
        throw new StockLimitExceededException("Item not present in stock");
    }

    public boolean hasStock(Item item){
        if(itemsStocks.containsKey(item) && itemsStocks.get(item) > 0){
            return true;
        }
        return false;
    }
}
