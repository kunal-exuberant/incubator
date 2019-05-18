package likedriving.design.BiddingEngine;

import java.util.List;

public class Bid{
    private int id;
    private String title;
    private List<Option> options;

    public Bid(int id, String title, List<Option> options){
        this.id = id;
        this.title = title;
        this.options = options;
    }

    public void modifyStake(User user) {

    }
}
