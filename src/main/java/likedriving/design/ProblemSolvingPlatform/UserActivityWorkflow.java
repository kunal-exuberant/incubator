package likedriving.design.ProblemSolvingPlatform;

import java.util.Scanner;

public class UserActivityWorkflow implements UserActivityWorkflowInterface{

    private ProblemStore problemStore;

    public UserActivityWorkflow(ProblemStore problemStore){
        this.problemStore = problemStore;
        bootstrap();
    }

    @Override
    public void createIssue(Scanner sc) {

        System.out.println("Please enter a problem title and description");
        System.out.print("\nProblem Title: ");

        String title = "";

        if(sc.hasNext()) {
            sc.nextLine();
            title = sc.nextLine();
        }
        Problem problem = new Problem(title);

        System.out.println("Problem created: "+problem.toString());

        System.out.print("\nProblem Description: ");

        if(sc.hasNext()) {
            problem.setDescription(sc.nextLine());
        }

        problemStore.add(problem);

        problemStore.save();

        System.out.println("Problem created and saved");
    }

    public void showProblems(){
        System.out.println("\nFollowing is the Problem list ...");
        if(problemStore.getProblemList().isEmpty() ){
            problemStore.load();
        }

        problemStore.getProblemList().forEach(System.out::println);
    }

    private void bootstrap(){
        problemStore.load();
    }
}
