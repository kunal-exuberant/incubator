package likedriving.design.CourtPiece;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Game {
    private int id;
    private int numberOfRounds;
    private int numberOfPlayers;
    private List<Card> cardList;
    private List<Player> players;

    CardType trump;
    Player getWinner(){

        return null;
    }

    public Game(){}

    Game(int id, int numberOfPlayers, int numberOfRounds){
        this.id = id;
        this.numberOfRounds = numberOfRounds;
        this.numberOfPlayers = numberOfPlayers;
    }

     void startTheGame(Game game){
        game.initializeCardList();
        game.distributeCards();
        //game.startRound();
        Utils.getScore(game.startRound());
    }

    private void initializeCardList(){
        this.cardList = new ArrayList<>();

        for(CardType cardType: CardType.values()){
            for(CardId cardId: CardId.values()){
                this.cardList.add(new Card(cardType, cardId));
            }
        }
    }

    private void distributeCards(){
        initializeCardList();
        initializePlayers();

        int totalNumberOfCards = cardList.size();

        System.out.println(totalNumberOfCards);

        for(int i=0; i< totalNumberOfCards; i++){
            this.players.get(i % this.numberOfPlayers).availableCards.add(Utils.getCard(cardList));
        }
    }

    private void initializePlayers(){
        this.players = new ArrayList<>();
        for(int i=0; i < numberOfPlayers; i++) {
            this.players.add(new Player(i, new ArrayList<Card>()));
        }
    }

    private Round[] startRound(){

        int roundId = 0;
        Player beginner = this.players.get(0);

        Player currentPlayer = beginner;

        Round [] rounds = new Round[this.numberOfRounds];

        for(Round round : rounds) {

            round = new Round(roundId, new HashMap<Player, Card>(), beginner);

            System.out.println("Starting Round: "+round.id);

            for (Player player : this.players) {
                System.out.println("----Player playing: " + currentPlayer.id);

                Card cardPlayed = Utils.playCard(currentPlayer);

                round.cardsPlayed.put(currentPlayer, cardPlayed);

                System.out.println("----Card played " + cardPlayed.id + " " + cardPlayed.type);

                currentPlayer = getNextPlayer(currentPlayer);
            }

            round.winner = getWinner(round);
            rounds[roundId] =(round);
            System.out.println("Winner of this round: "+round.winner.id);
            System.out.println();
            roundId++;
            beginner = round.winner;
        }

        return rounds;
    }

    private Player getWinner(Round round){

        int trumpValue = -1;
        Player trumpPlayer = null;
        int maxCarValue = -1;
        Player winningPlayer = null;
        for(Map.Entry<Player, Card> cardPlayed: round.cardsPlayed.entrySet()){

            int cardValue = cardPlayed.getValue().id.getCardIdValue();
            Player player = cardPlayed.getKey();

            if(cardPlayed.getValue().type == this.trump){
                    if (cardValue > trumpValue) {
                        trumpValue = cardPlayed.getValue().id.getCardIdValue();
                        trumpPlayer = cardPlayed.getKey();
                    }
            }else{

                if(cardValue > maxCarValue){
                    maxCarValue = cardValue;
                    winningPlayer = player;
                }
            }
        }
        return trumpValue == -1? winningPlayer: trumpPlayer;
    }

    private Player getNextPlayer(Player currentPlayer){
        return this.players.get((currentPlayer.id+1) % numberOfPlayers);
    }




    @Test
    public void test(){
        Game game = new Game(1, 4, 7);
        game.startTheGame(game);
        Assert.assertEquals(game.numberOfPlayers, 4);
        Assert.assertEquals(game.players.size(), 4);
        Assert.assertEquals(game.players.get(0).availableCards.size(), 13);
        Assert.assertEquals(game.players.get(1).availableCards.size(), 13);
        Assert.assertEquals(game.players.get(2).availableCards.size(), 13);
        Assert.assertEquals(game.players.get(3).availableCards.size(), 13);
    }
}
