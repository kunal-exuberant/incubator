package likedriving.design.LibraryManagementSystem;

import likedriving.design.LibraryManagementSystem.Exceptions.EntityNotFoundException;
import likedriving.design.LibraryManagementSystem.Exceptions.LendingLimitException;
import likedriving.design.LibraryManagementSystem.dataStores.BookStore;
import likedriving.design.LibraryManagementSystem.dataStores.BookToUserStore;
import likedriving.design.LibraryManagementSystem.dataStores.OrderStore;
import likedriving.design.LibraryManagementSystem.dataStores.UserStore;
import likedriving.design.LibraryManagementSystem.models.Book;
import likedriving.design.LibraryManagementSystem.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Workflow {

    private BookStore bookStore = new BookStore();
    private UserStore userStore = new UserStore();
    private OrderStore orderStore = new OrderStore();

    private BookToUserStore bookToUserStore = new BookToUserStore();

    private OrderProcessingImpl orderProcessing = new OrderProcessingImpl(orderStore, bookToUserStore);

    void addBooks(Scanner sc){

        System.out.println("Adding new books in the book store");
        System.out.println("How many books do you want to add to book store?");

        int bookCount = 0;
        try {
            bookCount = Integer.parseInt(sc.next());
            List<Book> bookList = new ArrayList<>();
            while(bookCount > 0) {

                long bookId = bookStore.getNextBookId();
                Book book = new Book();
                book.setId(bookId);

                System.out.println("Please input book title");
                book.setTitle(sc.next());

                System.out.println("Please input book author");
                book.setAuthor(sc.next());
                bookList.add(book);
                bookCount--;
            }
            bookStore.addBooks(bookList);
            System.out.println("Books add successfully");
        }catch (NumberFormatException e){
            System.out.println("Unable to catch the number"+ e);
        }
    }

    void addUsers(Scanner sc){

        System.out.println("Adding new users in the user store");
        System.out.println("How many users do you want to add to user store?");

        int userCount = 0;
        try {
            userCount = Integer.parseInt(sc.next());
        }catch (NumberFormatException e){
            System.out.println("Unable to catch the number"+ e);
        }
        List<User> userList = new ArrayList<>();
        while(userCount > 0) {

            long userId = bookStore.getNextBookId();
            User user = new User();
            user.setId(userId);

            System.out.println("Please input user name");
            user.setName(sc.next());

            userList.add(user);
            userCount--;
        }
        userStore.addUsers(userList);
        System.out.println("users add successfully");
    }

    void lendBooks(Scanner sc) throws EntityNotFoundException {
        System.out.println("Lending books to the user");
        System.out.println("Enter the user id who wants to lend: ");
        Long userId = Long.valueOf(-1);
        try {
            userId = Long.parseLong(sc.next());
        }catch (NumberFormatException e){
            System.out.println("Unable to catch the number"+ e);
        }

        User user = userStore.fetchUser(userId);

        System.out.println("How many books user wants to lend?");

        int bookCount = 0;
        try {
            bookCount = Integer.parseInt(sc.next());
        }catch (NumberFormatException e){
            System.out.println("Unable to catch the number"+ e);
        }
        List<Book> bookList = new ArrayList<>();
        while(bookCount > 0) {

            System.out.println("Enter the book id to lend: ");

            Long bookId = Long.valueOf(-1);
            try {
                bookId = Long.parseLong(sc.next());
            }catch (NumberFormatException e){
                System.out.println("Unable to catch the number"+ e);
            }

            Book book = bookStore.fetchBook(bookId);
            bookList.add(book);
            bookCount--;
        }
        try {
            orderProcessing.lendBooks(user, bookList);
        }catch (LendingLimitException e){
            System.out.println(e);
        }
        System.out.println("Books lent order placed successfully");
    }

    void returnBooks(Scanner sc) throws EntityNotFoundException{
        System.out.println("Returning books by the user");
        System.out.println("How many books do you want to return to book store?");

        int bookCount = 0;
        try {
            bookCount = Integer.parseInt(sc.next());
        }catch (NumberFormatException e){
            System.out.println("Unable to catch the number"+ e);
        }
        List<Book> bookList = new ArrayList<>();
        while(bookCount > 0) {

            System.out.println("Enter the book id to return: ");

            Long bookId = Long.valueOf(-1);
            try {
                bookId = Long.parseLong(sc.next());
            }catch (NumberFormatException e){
                System.out.println("Unable to catch the number"+ e);
            }
            Book book = bookStore.fetchBook(bookId);
            bookList.add(book);
            bookCount--;
        }
        System.out.println("Enter the user id who wants to lend: ");
        Long userId = Long.valueOf(-1);
        try {
            userId = Long.parseLong(sc.next());
        }catch (NumberFormatException e){
            System.out.println("Unable to catch the number"+ e);
        }

        User user = userStore.fetchUser(userId);
        orderProcessing.returnBooks(user, bookList);
    }

    void searchBookByAuthor(Scanner sc){
        System.out.println("Enter book author: ");
        for(Book book: bookStore.searchBookByAuthor(sc.next())){
            System.out.println(book.getTitle());
        }
    }

    void searchBookByTitle(Scanner sc){
        System.out.println("Enter book title: ");
        for(Book book: bookStore.searchBookByTitle(sc.next())){
            System.out.println(book.getTitle());
        }
    }

    void searchUserByName(Scanner sc){
        System.out.println("Enter user name: ");
        for(User user: userStore.searchUserByName(sc.next())){
            System.out.println(user.getName());
        }
    }

}
