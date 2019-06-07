package likedriving.design.ProblemSolvingPlatform;

public interface ProblemStoreInterface {
    void add(Problem problem);
    void markAsSolved(Problem problem);
    void markAsUnsolved(Problem problem);
    void deleteProblem(Problem problem);
}
