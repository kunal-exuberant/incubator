package likedriving.design.CallCenterSimulation;

public class CallOrchestrator {

    private int respondentN;
    private int managerN;
    private int directorN;

    private Respondent [] respondents;
    private Manager [] managers;
    private Director[] directors;
    private CallProcessingQueues callProcessingQueues;

    void grantResource(){
        respondents = new Respondent[respondentN];
        managers = new Manager[managerN];
        directors = new Director[directorN];
        callProcessingQueues = new CallProcessingQueues();
    }

    public void dispatchCall(Call call){

        call.status = CallStatus.UNATTENDED;
        callProcessingQueues.waiting.add(call);

        switch (call.ableToAttend) {
            case RESPONDENT:
                for(Respondent respondent: respondents){
                    if(respondent.isAvailable){
                        processCall(call, respondent);
                        return;
                    }
                }
                if(call.status == CallStatus.UNATTENDED){ escalate(call, Level.MANAGER); }
                break;
            case MANAGER:
                for(Manager manager: managers){
                    if(manager.isAvailable){
                        processCall(call, manager);
                        return;
                    }
                }
                if(call.status == CallStatus.UNATTENDED){ escalate(call, Level.DIRECTOR);}
                break;
            case DIRECTOR:
                for(Director director: directors){
                    if(director.isAvailable){
                        processCall(call, director);
                        return;
                    }
                }
                break;
        }
    }

    private void processCall(Call call, Employee employee){
        employee.assignedCall = call;
        employee.isAvailable = false;

        call.status = CallStatus.ATTENDED;
        call.assignedEmployee = employee;

        callProcessingQueues.waiting.remove(call);
        callProcessingQueues.executing.add(call);
    }

    private void escalate(Call call, Level level){

        call.ableToAttend = level;
        dispatchCall(call);
    }
}
