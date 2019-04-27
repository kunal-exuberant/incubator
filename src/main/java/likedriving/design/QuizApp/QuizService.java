package likedriving.design.QuizApp;

import likedriving.design.QuizApp.models.Quiz;
import likedriving.design.QuizApp.models.Workflow;

import java.io.FileNotFoundException;

public class QuizService {

    public static void main(String[] args) throws FileNotFoundException, Exception{
        Quiz quiz = new Quiz();

        Workflow workflow = new Workflow();

        workflow.execute(quiz);
    }
}
