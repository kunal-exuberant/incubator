package likedriving.design.LibraryManagementSystem;

import likedriving.design.LibraryManagementSystem.Exceptions.EntityNotFoundException;
import likedriving.design.LibraryManagementSystem.Exceptions.UnableToPlaceOrder;

import java.util.Scanner;

public class LMService {
    public static void main(String[] args) throws EntityNotFoundException, UnableToPlaceOrder {

        System.out.println("Hi, Welcome to Library Management System");
        System.out.println("Following are various functions you can perform, please chose one of them");
        System.out.println("1. Add books");
        System.out.println("2. Add users");
        System.out.println("3. Lend books");
        System.out.println("4. Return books");
        System.out.println("5. Search book by author");
        System.out.println("6. Search book by title");
        System.out.println("7. Search user by name");

        Workflow workflow = new Workflow();

        while (true){
            Scanner sc = new Scanner(System.in);
            int userAction = sc.nextInt();

            switch (userAction){
                case 1:
                    workflow.addBooks(sc);
                    break;

                case 2:
                    workflow.addUsers(sc);
                    break;

                case 3:
                    workflow.lendBooks(sc);
                    break;

                case 4:
                    workflow.returnBooks(sc);
                    break;

                case 5:
                    workflow.searchBookByAuthor(sc);
                    break;

                case 6:
                    workflow.searchBookByTitle(sc);
                    break;

                case 7:
                    workflow.searchUserByName(sc);
                    break;

                case -1:
                    System.out.println("Exiting the program");
                    break;

                default:
                    System.out.println("Default case");
            }
        }
    }
}
