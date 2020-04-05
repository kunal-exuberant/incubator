package likedriving.design.VendingMachine;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Money {
    private boolean isValid;
    private int value;
}
