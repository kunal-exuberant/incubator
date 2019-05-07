package likedriving.design.HomeInventoryManagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Quantity {
    private int amount;
    private Units unit;
}
