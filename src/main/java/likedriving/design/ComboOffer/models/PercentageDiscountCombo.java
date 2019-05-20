package likedriving.design.ComboOffer.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PercentageDiscountCombo extends DisbursalRule {

    public PercentageDiscountCombo() {
        super(DisbursalType.PERCENTAGE_DISCOUNT_COMBO);
    }

    private int percentageDiscount;
}
