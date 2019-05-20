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
    private List<ListingId> listingIdList;
    private DisbursalRule disbursalRule;

    @Override
    public void createOffer(List<ListingId> listingIds, DisbursalRule disbursalRule) {
        this.id = getId();
        this.listingIdList = listingIds;
        this.disbursalRule = disbursalRule;
    }
}
