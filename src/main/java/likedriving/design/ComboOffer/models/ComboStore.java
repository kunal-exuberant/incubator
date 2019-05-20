package likedriving.design.ComboOffer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ComboStore implements IComboStore{
    private List<Offer> comboStore = new ArrayList<>();

    @Override
    public void add(Offer offer) {
        comboStore.add(offer);
    }

    @Override
    public List<Offer> getAll() {
        return comboStore;
    }
}
