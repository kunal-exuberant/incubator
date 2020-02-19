package likedriving.design.VendingMachine;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class MoneyManager {
    private int totalAmount;

    public void incrementAmount(int itemPrice){
        this.totalAmount = this.totalAmount + itemPrice;
        log.info("Total amount in the money manager update to {}", this.totalAmount);
    }

    public void decrementAmount(int itemPrice){
        this.totalAmount = this.totalAmount - itemPrice;
        log.info("Total amount in the money manager update to {}", this.totalAmount);
    }
}
