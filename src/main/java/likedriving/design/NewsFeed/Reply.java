package likedriving.design.NewsFeed;

public class Reply extends Post{

    public Reply(String text, User postBy, Post parentPost) {
        super(text, postBy, PostType.REPLY, parentPost);

    }

    @Override
    public void createPost() {

    }
}
