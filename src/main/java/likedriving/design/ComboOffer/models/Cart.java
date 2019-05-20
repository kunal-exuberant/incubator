package likedriving.design.ComboOffer.models;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<ListingId, Price> listingIdPriceMap = new HashMap<>();
    private int totalCartPrice;
    private int totalCartDiscount;
}
