package likedriving.design.ProblemSolvingPlatform.impact;

import likedriving.design.ProblemSolvingPlatform.ImpactType;

public class ImpactFactory implements ImpactFactoryInterface {

    @Override
    public AbstractImpact createImpact(ImpactType impactType) {
        return AbstractImpact.getInstance(impactType);
    }
}
