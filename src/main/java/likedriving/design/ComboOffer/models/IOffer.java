package likedriving.design.ComboOffer.models;

import java.util.List;

public interface IOffer {
    void createOffer(List<ListingId> listingIds, DisbursalRule disbursalRule);
}
