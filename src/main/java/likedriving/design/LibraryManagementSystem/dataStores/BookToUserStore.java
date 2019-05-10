package likedriving.design.LibraryManagementSystem.dataStores;

import likedriving.design.LibraryManagementSystem.Exceptions.UnableToPlaceOrder;
import likedriving.design.LibraryManagementSystem.models.Book;
import likedriving.design.LibraryManagementSystem.models.User;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton

public class BookToUserStore{
    @Singleton
    private Map<Book, User> bookToUserStore = new HashMap<>();

    public void add(Book book, User placedBy) throws UnableToPlaceOrder{
        if(bookToUserStore.containsKey(book)){
            throw new UnableToPlaceOrder("Book is not available");
        }
        else{
            bookToUserStore.put(book, placedBy);
        }
    }

    public void remove(Book book) throws UnableToPlaceOrder{
        if(bookToUserStore.containsKey(book)){
            bookToUserStore.remove(book);
        }
        else{
            throw new UnableToPlaceOrder("Book was not reserved by this user");
        }
    }

    public int numberOfBooksLentByUser(User user){
        int numberOfBooks = 0;
        for(Map.Entry mapEntry: bookToUserStore.entrySet()){
            if(((User)mapEntry.getValue()).getId() == user.getId()){
                numberOfBooks++;
            }
        }
        return numberOfBooks;
    }
}
