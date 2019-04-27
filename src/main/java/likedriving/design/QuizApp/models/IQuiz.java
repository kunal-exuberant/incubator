package likedriving.design.QuizApp.models;

import java.io.FileNotFoundException;

public interface IQuiz {

    User getUser();

    Question loadQuestion(User user) throws FileNotFoundException;

    void askAnswer(User user, Question question);

    void generateScore(User user) throws Exception;

}
