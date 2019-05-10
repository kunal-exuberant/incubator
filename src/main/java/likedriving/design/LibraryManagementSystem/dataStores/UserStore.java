package likedriving.design.LibraryManagementSystem.dataStores;

import likedriving.design.LibraryManagementSystem.Exceptions.EntityNotFoundException;
import likedriving.design.LibraryManagementSystem.models.User;
import likedriving.design.LibraryManagementSystem.models.UserCommands;
import lombok.Synchronized;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserStore implements UserCommands {
    @Singleton
    private Map<Long, User> userStore = new HashMap<>();

    private long lastUserId = 0;

    @Synchronized
    public Long getNextUserId(){
        return lastUserId+1;
    }

    @Override
    public void addUsers(List<User> users) {
        for(User user: users){
            userStore.put(user.getId(), user);
        }
    }

    @Override
    public List<User> searchUserByName(String searchQuery) {
        List<User> searchResult = new ArrayList<>();
        for(Map.Entry<Long, User> userEntry: userStore.entrySet()){
            if(userEntry.getValue().getName().toLowerCase().contains(searchQuery.toLowerCase())){
                searchResult.add(userEntry.getValue());
            }
        }
        return searchResult;
    }

    @Override
    public User fetchUser(Long userId) throws EntityNotFoundException {
        if(userStore.containsKey(userId)) {
            return userStore.get(userId);
        }else{
            throw new EntityNotFoundException("User not present in user store");
        }
    }
}
