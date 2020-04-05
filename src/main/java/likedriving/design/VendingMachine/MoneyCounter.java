package likedriving.design.VendingMachine;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class MoneyCounter {
    public Optional<Integer> countMoney(Money money){
        // Apply some logic to figure out if the money is valid and count the money
        if(money.isValid()){
            return Optional.of(money.getValue());
        }
        else{
            log.info("Entered money is invalid");
            return Optional.empty();
        }
    }
}
