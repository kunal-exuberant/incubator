package likedriving.design.CourtPiece;

import java.util.List;

public class Player {
    int id;
    List<Card> availableCards;
    Player(int id, List<Card> availableCards){
        this.id = id;
        this.availableCards = availableCards;
    }
    public Card cardToPlay(){
        return null;
    }
}
