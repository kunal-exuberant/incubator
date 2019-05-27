package likedriving.design.NewsFeed;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class User implements UserMethods{
    private int id;
    private String name;
    private List<User> following = new ArrayList<>();

    private static int userId = 0;

    public User(String name){
        this.id = ++userId;
        this.name = name;
    }

    void follow(User user){
        user.following.add(this);
    }

    @Override
    public void createUser() {

    }
}