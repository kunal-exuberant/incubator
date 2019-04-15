package likedriving.design.CourtPiece;

public class Card {
    CardType type;
    CardId id;
    CardColor color;

    public Card(CardType type, CardId id){
        this.type = type;
        this.id = id;
        //this.color = type.getClass()
    }
}
