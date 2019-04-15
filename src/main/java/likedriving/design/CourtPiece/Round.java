package likedriving.design.CourtPiece;

import java.util.Map;

public class Round {
    int id;
    Map<Player, Card> cardsPlayed;
    Player beginner;
    Player winner;
    public Round(int id, Map<Player, Card> cardsPlayed, Player beginner){
        this.id = id;
        this.cardsPlayed = cardsPlayed;
        this.beginner = beginner;
    }
}
