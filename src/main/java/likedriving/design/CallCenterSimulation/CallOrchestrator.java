package likedriving.design.CallCenterSimulation;

import org.junit.Test;

import static java.lang.Thread.sleep;

public class CallOrchestrator {

    private int respondentN = 5;
    private int managerN = 3;
    private int directorN = 2;

    private Respondent [] respondents;
    private Manager [] managers;
    private Director[] directors;
    private CallProcessingQueues callProcessingQueues;

    public CallOrchestrator(){
        respondents = new Respondent[respondentN];
        for(int i=0; i< respondents.length; i++){
            respondents[i] = new Respondent();
        }
        managers = new Manager[managerN];
        for(int i=0; i< managers.length; i++){
            managers[i] = new Manager();
        }
        directors = new Director[directorN];
        for(int i=0; i< directors.length; i++){
            directors[i] = new Director();
        }
        callProcessingQueues = new CallProcessingQueues();
    }

    @Test
    public void callOrchestratorTest() throws InterruptedException{
        CallOrchestrator callOrchestrator = new CallOrchestrator();
        Call call = new Call(1, 1, Level.RESPONDENT);
        callOrchestrator.newCallArrived(call);
        callOrchestrator.dispatchCall();
        callOrchestrator.newCallArrived(new Call(2, 1, Level.RESPONDENT));
        callOrchestrator.completeCall();
    }

    private void newCallArrived(Call call){
        System.out.println("New call arrived and added to waiting queue: "+call.id);
        call.status = CallStatus.UNATTENDED;
        callProcessingQueues.waiting.add(call);
    }

    public void dispatchCall() throws InterruptedException {

        while(true) {
            if(callProcessingQueues.waiting.size()>0) {
                Call call = callProcessingQueues.waiting.remove();
                System.out.println("New call picked from waiting queue: " + call.id);

                switch (call.ableToAttend) {
                    case RESPONDENT:
                        for (Respondent respondent : respondents) {
                            if (respondent.isAvailable) {
                                processCall(call, respondent);
                            }
                        }
                        if (call.status == CallStatus.UNATTENDED) {
                            escalate(call, Level.MANAGER);
                        }
                        break;
                    case MANAGER:
                        for (Manager manager : managers) {
                            if (manager.isAvailable) {
                                processCall(call, manager);
                            }
                        }
                        if (call.status == CallStatus.UNATTENDED) {
                            escalate(call, Level.DIRECTOR);
                        }
                        break;
                    case DIRECTOR:
                        for (Director director : directors) {
                            if (director.isAvailable) {
                                processCall(call, director);
                            }
                        }
                        break;
                }
            }else {
                System.out.println("All the calls processed. There are no calls in waiting queue");
                sleep(1000);
            }
        }
    }

    private void processCall(Call call, Employee employee){
        employee.assignedCall = call;
        employee.isAvailable = false;

        call.status = CallStatus.ATTENDED;
        call.assignedEmployee = employee;

        callProcessingQueues.executing.add(call);
    }

    private void completeCall(){
        Call call = callProcessingQueues.executing.remove();
        System.out.println("Call completed successfully: "+call.id);
        call.status = CallStatus.COMPLETED;
        callProcessingQueues.completed.add(call);
    }

    private void escalate(Call call, Level level){
        System.out.println("Call escalated to next level: "+call.id);
        call.ableToAttend = level;
        call.status = CallStatus.UNATTENDED;
        callProcessingQueues.waiting.add(call);
    }
}
