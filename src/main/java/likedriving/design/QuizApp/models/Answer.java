package likedriving.design.QuizApp.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Answer {

    private long id;
    private String text;

    public Answer(long id){
        this.id = id;
    }
}
