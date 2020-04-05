package likedriving.design.VendingMachine;

import java.util.HashMap;
import java.util.Map;

public class VendingMachineApp {
    public static void main(String[] args) {
        MoneyCounter moneyCounter = new MoneyCounter();
        MoneyManager moneyManager = new MoneyManager();
        Item item = Item.builder().itemId(1).itemName("Cadbury").build();
        Stock stock = Stock.builder()
                .item(item)
                .unitCount(4)
                .unitPrice(40)
                .build();

        Map<Item, Integer> itemsStocks = new HashMap<>();
        itemsStocks.put(item, 4);
        StockManager stockManager = StockManager.builder()
                .stockCapacity(40)
                .itemsStocks(itemsStocks)
                .build();
        VendingMachine vendingMachine = new VendingMachine(stock, stockManager);
        TransactionManager transactionManager = new TransactionManager(vendingMachine, moneyCounter, stockManager, moneyManager, stock);
        try {
            transactionManager.startTransaction();
        }
        catch (StockLimitExceededException e){
            e.printStackTrace();
        }
    }
}
