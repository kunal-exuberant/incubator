package likedriving.workflowapp;

public class VehicleReachedRSAWorkflowContext extends StateWorkflowContext{

    @Override
    public void preExecute() {
        // Perform exclusive vehicle reached action for RSA workflow before execution of shared action
    }

    @Override
    public void postExecute() {
        // Perform exclusive vehicle reached action for RSA workflow post execution of shared action
    }
}
