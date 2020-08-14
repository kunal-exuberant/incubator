package likedriving.workflowapp;

public class VehicleReachedState extends AbstractState{
    public VehicleReachedState(StateWorkflowContext stateWorkflowContext) {
        super(stateWorkflowContext);
    }

    @Override
    public void sharedAction() {
        // Perform shared state actions
    }
}
