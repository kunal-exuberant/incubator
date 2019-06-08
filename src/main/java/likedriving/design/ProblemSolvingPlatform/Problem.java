package likedriving.design.ProblemSolvingPlatform;

import likedriving.design.ProblemSolvingPlatform.impact.AbstractImpact;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Problem extends AbstractProblem{

    public Problem(String title) {
        super(title);
    }

    public Problem(int id, String title, String description){
        super(id, title, description);
    }

    private List<AbstractImpact> impacts = new ArrayList<>();
    private Urgency urgency;
    private Solvability solvability;
    private Fund fund;
    private Effort timeToSolve;

    @Override
    public void define() {

    }

    @Override
    public void save() {

    }

    @Override
    public String toString(){
        return getId()+":"+getTitle()+":"+getDescription();
    }

    public static Problem deserialize(String problemString){

        String [] stringArray = problemString.split(":");
        return new Problem(Integer.parseInt(stringArray[0]), stringArray[1], stringArray[2]);
    }
}
