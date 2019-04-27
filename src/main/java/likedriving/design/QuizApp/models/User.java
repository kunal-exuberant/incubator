package likedriving.design.QuizApp.models;

import lombok.Data;

@Data
public class User {

    //private long id;

    private String name;

    private AttemptedQuestion attemptedQuestions;

    public User(String name){
        //this.id = id;
        this.name = name;
    }



}
