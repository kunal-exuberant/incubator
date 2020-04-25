package likedriving.JavaFundamentals.threads;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class SimulateRecursiveAction extends RecursiveAction {

    private int simulateWork;

    public SimulateRecursiveAction(int simulateWork){
        this.simulateWork = simulateWork;
    }

    @Override
    protected void compute() {
        if(simulateWork > 100){
            System.out.println("Parallel fork and join");
            SimulateRecursiveAction simulateRecursiveAction1 = new SimulateRecursiveAction(simulateWork/2);
            SimulateRecursiveAction simulateRecursiveAction2 = new SimulateRecursiveAction((simulateWork/2));

            simulateRecursiveAction1.fork();
            simulateRecursiveAction2.fork();
        }
        else {
            System.out.println("No need for parallel execution. Sequetion is ok "+simulateWork);
        }
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        SimulateRecursiveAction simulateRecursiveAction = new SimulateRecursiveAction(101);
        forkJoinPool.invoke(simulateRecursiveAction);
    }
}
