package likedriving.JavaFundamentals.threads;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class SimpleRecursiveTask extends RecursiveTask<Integer> {

    private int simulateWork;

    public SimpleRecursiveTask(int simulateWork){
        this.simulateWork = simulateWork;
    }

    @Override
    protected Integer compute() {

        if(simulateWork > 100){
            System.out.println("Parallel execution needed");

            SimpleRecursiveTask simpleRecursiveTask1 = new SimpleRecursiveTask(simulateWork/2);
            SimpleRecursiveTask simpleRecursiveTask2 = new SimpleRecursiveTask(simulateWork/2);


            simpleRecursiveTask1.fork();
            simpleRecursiveTask2.fork();

            int solution = 0;
            solution += simpleRecursiveTask1.join();
            solution += simpleRecursiveTask2.join();
            return solution;
        }
        else{
            System.out.println("Sequential work");
            return 2*simulateWork;
        }
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        SimpleRecursiveTask simpleRecursiveTask = new SimpleRecursiveTask(1640);
        Integer solution = forkJoinPool.invoke(simpleRecursiveTask);
        System.out.println(solution);
    }
}
