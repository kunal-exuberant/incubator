package likedriving.design.LibraryManagementSystem;

import likedriving.design.LibraryManagementSystem.Exceptions.LendingLimitException;
import likedriving.design.LibraryManagementSystem.Exceptions.UnableToPlaceOrder;
import likedriving.design.LibraryManagementSystem.dataStores.BookToUserStore;
import likedriving.design.LibraryManagementSystem.dataStores.OrderStore;
import likedriving.design.LibraryManagementSystem.models.Book;
import likedriving.design.LibraryManagementSystem.models.Order;
import likedriving.design.LibraryManagementSystem.models.OrderProcessing;
import likedriving.design.LibraryManagementSystem.models.User;

import javax.inject.Inject;
import java.util.List;

public class OrderProcessingImpl implements OrderProcessing {

    private OrderStore orderStore;
    private BookToUserStore bookToUserStore;
    private int userLendingLimit = 10;

    @Inject
    OrderProcessingImpl(OrderStore orderStore, BookToUserStore bookToUserStore){
        this.orderStore = orderStore;
        this.bookToUserStore = bookToUserStore;
    }

    @Override
    public void lendBooks(User placedBy, List<Book> books) throws LendingLimitException, UnableToPlaceOrder {
        if(bookToUserStore.numberOfBooksLentByUser(placedBy) > userLendingLimit){
            throw new LendingLimitException("User lending limit exceeded");
        }
        Order newOrder = new Order(orderStore.getNextOrderId(), placedBy, books, System.currentTimeMillis());

        for(Book book: books) {
            try {
                bookToUserStore.add(book, placedBy);
                orderStore.persistOrder(newOrder);
                System.out.println("Books lent successfully");
            }catch (UnableToPlaceOrder e){
                System.out.println(e);
                throw new UnableToPlaceOrder("Unable to place order");
            }
        }
    }

    @Override
    public void returnBooks(User returnedBy, List<Book> books) {

        for(Book book: books) {
            try {
                bookToUserStore.remove(book);
                Order newOrder = new Order(orderStore.getNextOrderId(), returnedBy, books, System.currentTimeMillis());
                orderStore.persistOrder(newOrder);
                System.out.println("Books returned successfully");
            }catch (UnableToPlaceOrder e){
                System.out.println(e);
            }
        }
    }
}
