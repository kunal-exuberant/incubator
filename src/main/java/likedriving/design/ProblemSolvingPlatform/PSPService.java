package likedriving.design.ProblemSolvingPlatform;

import java.util.Scanner;

public class PSPService {

    private static Scanner sc;

    private static UserActivityWorkflow userActivityWorkflow;

    public static void main(String[] args) {

        sc = new Scanner(System.in);
        userActivityWorkflow = new UserActivityWorkflow(new ProblemStore());

        boolean shouldExit = false;

        while (true){

            System.out.println("\n\nPlease select one of the following options");
            System.out.println("1. Define a problem");
            System.out.println("2. Show problem list");
            System.out.println("3. Exit");

            System.out.print("\nYour choice: ");


            switch (sc.nextInt()){

                case 1:

                    userActivityWorkflow.createIssue(sc);
                    break;

                case 2:

                    userActivityWorkflow.showProblems();
                    break;

                case 3:

                    shouldExit = true;
                    break;
            }

            if(shouldExit) break;

        }


    }

}
