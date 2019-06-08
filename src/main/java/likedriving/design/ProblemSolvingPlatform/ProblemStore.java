package likedriving.design.ProblemSolvingPlatform;

import likedriving.TechStacks.Redis.RedisClient;
import likedriving.TechStacks.Redis.RedisConfiguration;
import lombok.Data;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
public class ProblemStore implements ProblemStoreInterface{

    private List<Problem> problemList = new ArrayList<>();

    Jedis jedis = RedisClient.getConnection(new RedisConfiguration());;

    @Override
    public void add(Problem problem) {
        problemList.add(problem);
    }

    @Override
    public void markAsSolved(Problem problem) {

    }

    @Override
    public void markAsUnsolved(Problem problem) {

    }

    @Override
    public void deleteProblem(Problem problem) {

    }

    String [] stringify(){
        String [] problemString = new String[problemList.size()];
        int i=0;
        for(Problem problem: problemList) {
            problemString[i] = problem.toString();
            i++;
        }
        return problemString;
    }

    @Override
    public void save() {

        jedis.sadd("problemList", stringify());
    }

    public void load(){

        if(!jedis.exists("problemList")){
            System.out.println("Problem list is empty");
            return;
        }
        Set<String> problemArray = jedis.smembers("problemList");
        if(problemArray.isEmpty()){
            System.out.println("Problem list is empty "+problemArray);
            return;
        }

        for(String p: problemArray){
            if(p != null) {
                problemList.add(Problem.deserialize(p));
            }
        }
    }
}
