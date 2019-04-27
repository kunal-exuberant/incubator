package likedriving.design.QuizApp.models;

import java.io.FileNotFoundException;

public class Workflow {

    private int noOfQuestions = 3;

    void execute(Quiz quiz) throws FileNotFoundException, Exception {
        User user = quiz.getUser();

        int questionCounter = 0;
        while(questionCounter < this.noOfQuestions) {
            Question question = quiz.loadQuestion(user);
            quiz.askAnswer(user, question);
            quiz.generateScore(user);
            questionCounter++;
        }
    }

}
