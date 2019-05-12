package likedriving.design.BiddingEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Outcome {
    private Option result;
    private List<User> winners;
    private List<User> losers;
    private Map<User, Integer> pointsEarned = new HashMap<>();
}
