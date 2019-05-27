package likedriving.design.NewsFeed;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class PostStore {
    private Map<User, List<Post>> postStore = new HashMap<>();
}
