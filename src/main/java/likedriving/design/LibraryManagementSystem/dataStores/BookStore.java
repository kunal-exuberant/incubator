package likedriving.design.LibraryManagementSystem.dataStores;

import likedriving.design.LibraryManagementSystem.Exceptions.EntityNotFoundException;
import likedriving.design.LibraryManagementSystem.models.Book;
import likedriving.design.LibraryManagementSystem.models.BookCommands;
import lombok.Synchronized;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Singleton
public class BookStore implements BookCommands {

    private long lastBookId = 0;

    @Singleton
    private Map<Long, Book> bookStore = new HashMap<>();

    @Synchronized
    public Long getNextBookId(){
        return lastBookId+1;
    }

    @Override
    public void addBooks(List<Book> books) {
        for(Book book: books) {
            bookStore.put(book.getId(), book);
        }
    }

    @Override
    public List<Book> searchBookByTitle(String searchQuery) {
        List<Book> searchResult = new ArrayList<>();
        for(Map.Entry<Long, Book> bookEntry: bookStore.entrySet()){
            if(bookEntry.getValue().getTitle().toLowerCase().contains(searchQuery.toLowerCase())){
                searchResult.add(bookEntry.getValue());
            }
        }
        return searchResult;
    }

    @Override
    public List<Book> searchBookByAuthor(String searchQuery) {
        List<Book> searchResult = new ArrayList<>();
        for(Map.Entry<Long, Book> bookEntry: bookStore.entrySet()){
            if(bookEntry.getValue().getAuthor().toLowerCase().contains(searchQuery.toLowerCase())){
                searchResult.add(bookEntry.getValue());
            }
        }
        return searchResult;
    }

    @Override
    public Book fetchBook(Long bookId) throws EntityNotFoundException {
        if(bookStore.containsKey(bookId)) {
            return bookStore.get(bookId);
        }else{
            throw new EntityNotFoundException("Book not present in book store");
        }
    }
}
