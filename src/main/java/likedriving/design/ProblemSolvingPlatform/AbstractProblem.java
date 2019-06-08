package likedriving.design.ProblemSolvingPlatform;

import lombok.Data;

@Data
public abstract class AbstractProblem implements ProblemInterface{

    private int id;
    private String title;
    private String description;

    private static int problemId = 0;

    public AbstractProblem(String title){
        this.id = ++problemId;
        this.title = title;
    }

    public AbstractProblem(int id, String title, String description){
        this.id = id;
        this.title = title;
        this.description = description;
    }
}
