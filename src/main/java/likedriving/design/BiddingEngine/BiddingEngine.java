package likedriving.design.BiddingEngine;

import lombok.Synchronized;

import java.util.ArrayList;
import java.util.List;

public class BiddingEngine implements BiddingInterface{
     List<Bid> runningBids = new ArrayList<>();

    private static int lastBidId = 0;

    @Synchronized
    public static int getNextBidId(){
        return lastBidId+1;
    }

    @Override
    public void createBid(String title, List<Option> options) {
        Bid bid = new Bid(getNextBidId(), title, options);
        runningBids.add(bid);
    }
}
