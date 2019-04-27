package likedriving.design.QuizApp.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class Option {

    @NotNull
    private long id;

    @Min(1) @Max(200) @NotNull
    private String text;

    public Option(long id){
        this.id = id;
    }

}
