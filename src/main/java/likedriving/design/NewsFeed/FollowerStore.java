package likedriving.design.NewsFeed;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class FollowerStore {
    private Map<User, List<User>> followerStore = new HashMap<>();
}
