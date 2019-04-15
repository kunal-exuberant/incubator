package likedriving.design.CallCenterSimulation;

public abstract class Employee {
    int id;
    Level level;
    boolean isAvailable;
    Call assignedCall;
    Employee(Level level){
        this.level = level;
    }
}
