package likedriving.design.CallCenterSimulation;

import java.util.ArrayList;
import java.util.List;

public class CallProcessingQueues {
    List<Call> waiting = new ArrayList<>();
    List<Call> executing = new ArrayList<>();
    List<Call> completed = new ArrayList<>();
}
