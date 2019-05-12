package likedriving.design.BiddingEngine;

import java.util.HashMap;
import java.util.Map;

public class BidParticipants {
    private Map<Bid, UserStake> bidParticipants = new HashMap<>();


    public void joinBid(Bid bid, User user) {

        if(bidParticipants.containsKey(bid)){

        }

        //bidParticipants.put(bid, user);

    }


    public void leaveBid(User user) {

    }
}
