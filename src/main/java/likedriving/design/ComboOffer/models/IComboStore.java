package likedriving.design.ComboOffer.models;

import java.util.List;

public interface IComboStore {

    void add(Offer offer);
    List<Offer> getAll();
}
