package likedriving.workflowapp;

public abstract class StateWorkflowContext {
    public abstract void preExecute();
    public abstract void postExecute();
}
