package likedriving.design.LibraryManagementSystem.models;

import likedriving.design.LibraryManagementSystem.Exceptions.EntityNotFoundException;

import java.util.List;

public interface GenericCommands<T> {

    void addObjects(List<T> objects);
    List<T> searchObjectByQuery(String str);
    T fetchObject(Long id) throws EntityNotFoundException;
}
