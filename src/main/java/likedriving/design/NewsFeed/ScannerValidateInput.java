package likedriving.design.NewsFeed;

import java.util.Scanner;

public class ScannerValidateInput {

    private Scanner sc;

    public ScannerValidateInput(Scanner sc){
        this.sc = sc;
    }

    public void validatePositiveInteger(){
        String userInput = sc.next();

        if(Integer.parseInt(userInput) < 0){
            System.out.println("Invalid Input");
        }
    }

    public static void main(String[] args) {
        new ScannerValidateInput(new Scanner(System.in)).validatePositiveInteger();
    }
}
