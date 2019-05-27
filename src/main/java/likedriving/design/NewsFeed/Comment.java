package likedriving.design.NewsFeed;

import java.util.ArrayList;
import java.util.List;

public class Comment extends Post {

    private List<Reply> replyList = new ArrayList<>();
    public Comment(String text, User postBy, Post parentPost) {
        super(text, postBy, PostType.COMMENT, parentPost);

    }

    @Override
    public void createPost() {

    }
}
