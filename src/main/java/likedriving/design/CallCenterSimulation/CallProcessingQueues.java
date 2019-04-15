package likedriving.design.CallCenterSimulation;

import java.util.LinkedList;
import java.util.Queue;

public class CallProcessingQueues {
    static Queue<Call> waiting = new LinkedList<>();
    static Queue<Call> executing = new LinkedList<>();
    static Queue<Call> completed = new LinkedList<>();
}
