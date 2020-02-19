package likedriving.design.VendingMachine;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class TransactionManager {

    private static int transactionId = 0;
    private VendingMachine vendingMachine;
    private MoneyCounter moneyCounter;
    private StockManager stockManager;
    private MoneyManager moneyManager;
    private Stock stock;

    public TransactionManager(VendingMachine vendingMachine, MoneyCounter moneyCounter, StockManager stockManager,
                              MoneyManager moneyManager, Stock stock){
        this.vendingMachine = vendingMachine;
        this.stockManager = stockManager;
        this.moneyCounter = moneyCounter;
        this.moneyManager = moneyManager;
        this.stock = stock;
    }

    public void startTransaction() throws StockLimitExceededException {
        log.info("Starting a new transaction with transaction id {}", transactionId+1);
        transactionId++;
        if(vendingMachine.activate()){
            Optional<Integer> optionalMoney =  moneyCounter.countMoney(vendingMachine.collectMoney());
            if(optionalMoney.isPresent()){
                Optional<Item> optionalItem = stock.getItemWithPrice(optionalMoney.get());
                if(optionalItem.isPresent()) {
                    if (stockManager.hasStock(optionalItem.get())) {
                        vendingMachine.vend(optionalMoney.get());
                        moneyManager.incrementAmount(optionalMoney.get());
                        UserInterface.successMessage();
                        return;
                    }
                }
            }
        }
        UserInterface.failureMessage();
    }
}
