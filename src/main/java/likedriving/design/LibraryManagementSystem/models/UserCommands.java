package likedriving.design.LibraryManagementSystem.models;

import likedriving.design.LibraryManagementSystem.Exceptions.EntityNotFoundException;

import java.util.List;

public interface UserCommands {
    void addUsers(List<User> users);
    List<User> searchUserByName(String name);
    User fetchUser(Long userId) throws EntityNotFoundException;
}