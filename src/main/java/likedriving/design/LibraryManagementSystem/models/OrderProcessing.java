package likedriving.design.LibraryManagementSystem.models;

import likedriving.design.LibraryManagementSystem.Exceptions.LendingLimitException;
import likedriving.design.LibraryManagementSystem.Exceptions.UnableToPlaceOrder;

import java.util.List;

public interface OrderProcessing {
    void lendBooks(User placedBy, List<Book> books) throws LendingLimitException, UnableToPlaceOrder;
    void returnBooks(User returnedBy, List<Book> books);
}
