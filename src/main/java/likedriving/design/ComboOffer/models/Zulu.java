package likedriving.design.ComboOffer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Zulu {
    private Map<ListingId, Price> zulu = new HashMap<>();

    {
        zulu.put(new ListingId(Long.valueOf(1)), new Price(PriceType.FP, 100));
        zulu.put(new ListingId(Long.valueOf(2)), new Price(PriceType.FP, 200));
        zulu.put(new ListingId(Long.valueOf(3)), new Price(PriceType.FP, 300));
        zulu.put(new ListingId(Long.valueOf(4)), new Price(PriceType.FP, 400));
        zulu.put(new ListingId(Long.valueOf(5)), new Price(PriceType.FP, 500));
        zulu.put(new ListingId(Long.valueOf(6)), new Price(PriceType.FP, 600));
        zulu.put(new ListingId(Long.valueOf(7)), new Price(PriceType.FP, 700));
        zulu.put(new ListingId(Long.valueOf(8)), new Price(PriceType.FP, 800));
        zulu.put(new ListingId(Long.valueOf(9)), new Price(PriceType.FP, 900));
        zulu.put(new ListingId(Long.valueOf(10)), new Price(PriceType.FP, 1000));
    }
}
