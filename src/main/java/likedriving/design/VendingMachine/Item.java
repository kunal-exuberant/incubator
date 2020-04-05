package likedriving.design.VendingMachine;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class Item {
    private int itemId;
    private String itemName;
}
