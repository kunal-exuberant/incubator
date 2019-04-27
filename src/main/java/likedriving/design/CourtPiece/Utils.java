package likedriving.design.CourtPiece;

import java.util.*;

public class Utils {
    static Card playCard(Player player){
        Random random = new Random();
        int cardPlayed = random.nextInt(player.availableCards.size());
        return player.availableCards.remove(cardPlayed);
    }

    static Card getCard(List<Card> cardList) {
        Random random = new Random();
        int randomCardIndex = random.nextInt(cardList.size());
        return cardList.remove(randomCardIndex);
    }

    static void getScore(Round[] rounds){
        Map<Player, List<Round>> score = new HashMap<>();
        for(Round round : rounds) {
            if(score.containsKey(round.winner)){
                List<Round> roundsWon = new ArrayList<>();
                roundsWon.addAll(score.get(round.winner));
                roundsWon.add(round);
                score.put(round.winner, roundsWon);
            }else {
                score.put(round.winner, Arrays.asList(round));
            }
        }

        System.out.println("Score board");
        for(Map.Entry s: score.entrySet()) {
            System.out.print("Player "+((Player)s.getKey()).id+": ");
            for(Round round : (List<Round>)s.getValue()) {
                System.out.print(round.id+",");
            }
            System.out.println();
        }
    }
}
