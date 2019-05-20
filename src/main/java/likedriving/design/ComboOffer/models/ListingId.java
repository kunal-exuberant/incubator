package likedriving.design.ComboOffer.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ListingId {
    private long id;

    @Override
    public boolean equals(Object listingId){
        if(((ListingId)listingId).getId() == this.id){
            return true;
        }
        return false;
    }
}
