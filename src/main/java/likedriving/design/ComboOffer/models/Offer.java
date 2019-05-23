package likedriving.design.ComboOffer.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class Offer implements IOffer {

    private int id = 0;
    private List<String> productGroups;
    private DisbursalRule disbursalRule;


    public Offer(List<String> productGroups, DisbursalRule disbursalRule) {
        this.id = getId()+1;
        this.productGroups = productGroups;
        this.disbursalRule = disbursalRule;
    }
}
