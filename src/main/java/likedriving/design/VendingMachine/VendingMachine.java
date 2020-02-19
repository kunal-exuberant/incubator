package likedriving.design.VendingMachine;

import com.google.inject.Inject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Data
@Slf4j
public class VendingMachine {
    private Stock stock;
    private StockManager stockManager;
    private boolean active;

    @Inject
    public VendingMachine(Stock stock, StockManager stockManager){
        this.stock = stock;
        this.stockManager = stockManager;
    }

    public void vend(int amount) throws StockLimitExceededException {
        Optional<Item> optionalItem = stock.getItemWithPrice(amount);
        stockManager.vendStock(optionalItem.get());
    }

    public boolean activate() {
        log.info("Activating the vending machine");
        if(!this.active){
            this.active = true;
            return this.active;
        }
        else{
            log.info("Vending machine is already active");
            return false;
        }
    }

    public boolean dectivate() {
        log.info("Deactivating the vending machine");
        if(this.active){
            this.active = false;
            return true;
        }
        else{
            log.info("Vending machine is already inactive");
            return false;
        }
    }

    public Money collectMoney(){
        log.info("Collecting the money provided by the user");
        return new Money(true, 40);
    }
}
