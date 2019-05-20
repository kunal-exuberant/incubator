package likedriving.design.ComboOffer.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FixedDiscountCombo extends DisbursalRule {

    public FixedDiscountCombo(){
        super(DisbursalType.FIXED_DISCOUNT_COMBO);
    }

    private int flatDiscount;
}
