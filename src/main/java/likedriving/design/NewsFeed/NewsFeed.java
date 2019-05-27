package likedriving.design.NewsFeed;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NewsFeed {

    private static UserStore userStore;
    private static PostStore postStore;
    private static FollowerStore followerStore;


    public NewsFeed(UserStore userStore, PostStore postStore, FollowerStore followerStore){
        this.userStore = userStore;
        this.postStore = postStore;
        this.followerStore = followerStore;
    }

    public static void main(String[] args) {

        NewsFeed newsFeed = new NewsFeed(new UserStore(), new PostStore(), new FollowerStore());
        User user;
        Post post;
        User loggedInUser = null;

        System.out.println("Select one of the following commands");
        System.out.println("Signup");
        System.out.println("Login");
        System.out.println("Follow");
        System.out.println("ShownewsFeed");
        System.out.println("Comment");
        System.out.println("Reply");
        System.out.println("Logout");
        System.out.println("Upvote");
        System.out.println("Downvote");

        Scanner sc = new Scanner(System.in);

        while(true){

            switch (sc.next()){
                case "Signup":
                    System.out.println("Trying to signup ...");
                    System.out.println("Enter your username");
                    String userName = sc.next();
                    user = new User(userName);
                    userStore.getUserStore().put(userName, user);
                    System.out.println("User created Successfully with userId: "+user.getId());
                    break;

                case "Login":
                    System.out.println("Trying to login ...");
                    System.out.println("Enter your username");
                    userName = sc.next();
                    loggedInUser = userStore.getUserStore().get(userName);
                    if(loggedInUser == null){
                        System.out.println("Please signup first");
                        break;
                    }
                    System.out.println("User logged in successfully with userId: "+loggedInUser.getId());
                    break;

                case "Follow":
                    if(loggedInUser == null){
                        System.out.println("Please login first");
                        break;
                    }
                    System.out.println("Enter the username to follow");
                    userName = sc.next();
                    if(loggedInUser.getName() == userName){
                        System.out.println("Self following is not legal");
                        break;
                    }
                    user = userStore.getUserStore().get(userName);
                    if(user == null){
                        System.out.println("user to follow does not exist");
                        break;
                    }
                    if(followerStore.getFollowerStore().containsKey(loggedInUser)){
                        List<User> following = followerStore.getFollowerStore().get(loggedInUser);
                        following.add(user);
                        followerStore.getFollowerStore().put(loggedInUser, following);
                    }
                    else{
                        followerStore.getFollowerStore().put(loggedInUser, Collections.singletonList(user));
                    }

                    System.out.println("Started following the user");

                    break;
                case "ShownewsFeed":
                    for(User following :followerStore.getFollowerStore().get(loggedInUser)){
                        for(Post post1: postStore.getPostStore().get(following)){
                            System.out.println(following.getName());
                            System.out.println(post1.getText());
                            System.out.println(post1.getUpVote());
                            System.out.println(post1.getDownVote());
                            System.out.println(post1.getTimestamp());
                        }
                    }

                    break;
                case "Status":
                    System.out.println("Enter the status");
                    post = new Status(sc.next(), loggedInUser, null);


                    if(postStore.getPostStore().containsKey(loggedInUser)){
                        List<Post> posts = postStore.getPostStore().get(loggedInUser);
                        posts.add(post);
                        postStore.getPostStore().put(loggedInUser, posts);
                    }
                    else{
                        postStore.getPostStore().put(loggedInUser, Collections.singletonList(post));
                    }
                    System.out.println("Status updated successfully");
                    break;
                case "Comment":
                    System.out.println("Enter the Status Id to comment on");
                    int parentPost = sc.nextInt();
                    System.out.println("Enter the comment");
                    String text = sc.next();

                    post = new Comment(text, loggedInUser, null);
                    //postStore.getPostStore().put(loggedInUser, post);
                    System.out.println("Status updated successfully");
                    break;
                case "Reply":
                    break;
                case "Logout":
                    break;
                case "Upvote":
                    break;
                case "Downvote":
                    break;
            }
        }
    }
}
