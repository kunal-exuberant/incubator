package likedriving.design.CallCenterSimulation;

public class Call {
    int id;
    int durationInMinutes;
    CallStatus status;
    Level ableToAttend;
    Employee assignedEmployee;
    public Call(int id, int durationInMinutes, Level ableToAttend){

        this.id = id;
        this.durationInMinutes = durationInMinutes;
        this.ableToAttend = ableToAttend;
    }
}
