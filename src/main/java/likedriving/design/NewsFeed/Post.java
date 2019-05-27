package likedriving.design.NewsFeed;

import lombok.Data;

@Data
public abstract class Post implements PostMethods{
    private int id;
    private String text;
    private PostType postType;
    private Post parentPost;
    private User postBy;
    private int upVote;
    private int downVote;
    private long timestamp;

    private static int postId = 0;

    public Post(String text, User postBy, PostType postType, Post parentPost){
        this.id = ++postId;
        this.text = text;
        this.postBy = postBy;
        this.parentPost = parentPost;
        this.timestamp = System.currentTimeMillis();
    }
}