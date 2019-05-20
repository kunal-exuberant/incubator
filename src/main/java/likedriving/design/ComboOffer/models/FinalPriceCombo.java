package likedriving.design.ComboOffer.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FinalPriceCombo extends DisbursalRule {

    private int finalPrice;
    public FinalPriceCombo() {
        super(DisbursalType.FINAL_PRICE_COMBO);
    }
}