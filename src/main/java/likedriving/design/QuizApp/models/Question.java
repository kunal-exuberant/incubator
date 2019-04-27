package likedriving.design.QuizApp.models;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class Question {

    private long id;

    private QuestionType questionType;

    @Min(50) @Max(100)
    @NotNull
    private String text;

    @Min(100) @Max(200)
    private String description;

    private List<Option> options;

    private List<Answer> answers;

}
