package likedriving.JavaFundamentals.threads;

public class ParallelAlgorithm {

    public static void main(String[] args) {
        System.out.println("Available Processors: "+ Runtime.getRuntime().availableProcessors());
        System.out.println("Free memory: "+Runtime.getRuntime().freeMemory());
        System.out.println("Maximum memory: "+Runtime.getRuntime().maxMemory());
        System.out.println("Total memory: "+Runtime.getRuntime().totalMemory());
        System.out.println();
    }



    public int sequentialSum(int [] array){
        int sum = 0;
        for(int a: array){
            sum += a;
        }
        return sum;
    }
}
