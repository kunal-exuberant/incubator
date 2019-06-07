package likedriving.design.ProblemSolvingPlatform.impact;


import likedriving.design.ProblemSolvingPlatform.ImpactType;

public interface ImpactFactoryInterface {
    AbstractImpact createImpact(ImpactType impactType);
}
