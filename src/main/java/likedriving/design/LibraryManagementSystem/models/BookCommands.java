package likedriving.design.LibraryManagementSystem.models;

import likedriving.design.LibraryManagementSystem.Exceptions.EntityNotFoundException;

import java.util.List;

public interface BookCommands {
    void addBooks(List<Book> books);
    List<Book> searchBookByTitle(String name);
    List<Book> searchBookByAuthor(String title);
    Book fetchBook(Long bookId) throws EntityNotFoundException;
}
