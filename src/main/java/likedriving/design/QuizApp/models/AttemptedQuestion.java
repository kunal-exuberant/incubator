package likedriving.design.QuizApp.models;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class AttemptedQuestion {
    private Map<Question, Option> attemptedQuestion = new HashMap<>();
}
