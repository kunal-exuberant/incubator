package likedriving.design.ProblemSolvingPlatform.impact;

import likedriving.design.ProblemSolvingPlatform.ImpactType;
import lombok.Data;

@Data
public class AbstractImpact {
    private ImpactType impactType;
    public AbstractImpact(ImpactType impactType){
        this.impactType = impactType;
    }

    private static AbstractImpact abstractImpact;

    public static AbstractImpact getInstance(ImpactType impactType){
        abstractImpact = new AbstractImpact(impactType);
        return abstractImpact;
    }
}
