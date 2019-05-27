package likedriving.design.NewsFeed;

import java.util.ArrayList;
import java.util.List;

public class Status extends Post {

    private List<Comment> commentList = new ArrayList<>();
    public Status(String text, User postBy, Post parentPost) {
        super(text, postBy, PostType.STATUS, parentPost);
    }

    @Override
    public void createPost() {

    }
}
