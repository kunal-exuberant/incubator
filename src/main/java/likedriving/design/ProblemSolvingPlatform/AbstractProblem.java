package likedriving.design.ProblemSolvingPlatform;

import likedriving.design.ProblemSolvingPlatform.impact.AbstractImpact;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AbstractProblem implements ProblemInterface{

    private int id;
    private String title;
    private String description;
    private List<AbstractImpact> impacts = new ArrayList<>();
    private Urgency urgency;
    private Solvability solvability;
    private Fund fund;
    private Effort timeToSolve;

    public AbstractProblem(int id, String title){
        this.id = id;
        this.title = title;
    }


    @Override
    public void define() {

    }

    @Override
    public void save() {

    }
}
