package likedriving.design.ComboOffer.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Data
public class FinalPriceCohort extends DisbursalRule{
    public FinalPriceCohort(){
        //super(DisbursalType.FINAL_PRICE_COHORT);
    }

    private Map<String, Price> finalPrice = new HashMap<>();
}
