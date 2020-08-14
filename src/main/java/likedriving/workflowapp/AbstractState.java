package likedriving.workflowapp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractState implements IState{

    protected RMTStateIdentifiers rmtStateIdentifier;

    protected StateWorkflowContext stateWorkflowContext;

    public AbstractState(StateWorkflowContext stateWorkflowContext){
        this.stateWorkflowContext = stateWorkflowContext;
    }

    private final void logStateEntry() {
        log.info("Transitioned into current state ");
    }

    @Override
    public final void performAction() {
        logStateEntry();
        stateWorkflowContext.preExecute();

        // Perform shared state actions
        sharedAction();

        stateWorkflowContext.postExecute();
        updateStateTransition();
        return;
    }

    private final void updateStateTransition() {
        // Update this state in database or other systems
    }
}
