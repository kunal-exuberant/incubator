package likedriving.design.NewsFeed;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class UserStore {
    private Map<String, User> userStore = new HashMap<>();
}
