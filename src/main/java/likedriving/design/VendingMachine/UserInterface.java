package likedriving.design.VendingMachine;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@Data
@Slf4j
public class UserInterface {
    public static void successMessage(){
        log.info("Product vended successfully");
    }

    public static void failureMessage(){
        log.info("Product vending failed");
    }
}
