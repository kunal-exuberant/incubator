package likedriving.workflowapp;

public interface IState {
    void performAction();
    void sharedAction();
}
