package likedriving.design.ParallelLogProcessing;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ParallelLogProcessing {

    public static void main(String[] args) throws IOException {

        String [] fileUrl = {"/Users/kunalsingh.k/likedriving/src/main/java/likedriving/design/ParallelLogProcessing/log1.txt"};

        Scanner sc = new Scanner(new File(fileUrl[0]));

        Map<Long, Map<String, Integer>> map = new TreeMap<>();

        while(sc.hasNext()) {

            sc.nextLong(); // Simply consuming the logId
            Long timeStamp = sc.nextLong();
            String exception = sc.next();

            if(map.isEmpty()){
                Map<String, Integer> hMap = new HashMap<>();
                hMap.put(exception, 1);
                map.put(timeStamp, hMap);
            }
            else{
                boolean timeStampInRange = false;
                for(Map.Entry<Long, Map<String, Integer>> entry : map.entrySet()){
                    if (timeStamp >= entry.getKey() && timeStamp < entry.getKey() + 15*60*1000) {
                        timeStampInRange = true;
                        System.out.println("Timestamp in Range "+timeStamp);
                        insert(map, entry.getKey(), exception);
                    }
                }
                    if(!timeStampInRange) {
                        Long nextKey = null;
                        if( timeStamp > ((TreeMap<Long, Map<String, Integer>>) map).lastKey()){
                            System.out.println("Greater Than last");
                            Long baseNextKey = ((TreeMap<Long, Map<String, Integer>>) map).lastKey();
                            while(baseNextKey + Long.valueOf(15*60*1000) <= timeStamp){
                                baseNextKey = baseNextKey + Long.valueOf(15*60*1000);
                            }

                            nextKey = baseNextKey;
                            System.out.println(nextKey+" "+timeStamp+" "+exception);

                        } else if(timeStamp < ((TreeMap<Long, Map<String, Integer>>) map).firstKey()){
                            System.out.println("Less than first");
                            Long basePrevKey = ((TreeMap<Long, Map<String, Integer>>) map).firstKey();

                            while(basePrevKey > timeStamp){
                                System.out.println(basePrevKey);
                                basePrevKey = basePrevKey - Long.valueOf(15*60*1000);
                                System.out.println(basePrevKey);
                            }
                            nextKey = basePrevKey;
                            System.out.println(nextKey+" "+timeStamp+" "+exception);
                        }
                        if(nextKey != null) {
                            insert(map, nextKey, exception);
                        }
                    }
            }
        }
        printLog(map);
    }

    private static void printLog(Map<Long, Map<String, Integer>> map){
        System.out.println();
        System.out.println("************************** Output *******************************");
        for(Map.Entry<Long, Map<String, Integer>> entry: map.entrySet()){
            for(Map.Entry exceptionLog : ((HashMap<String, Integer>)entry.getValue()).entrySet()){
                System.out.println((new Date(entry.getKey()))+" - "+new Date(entry.getKey()+15*60*1000)+" "+ exceptionLog.getKey()+" "+exceptionLog.getValue());
            }
        }
    }

    private static void insert(Map<Long, Map<String, Integer>> map, Long timeStamp, String exception){

        if(map.containsKey(timeStamp)) {
            Map<String, Integer> hMap = map.get(timeStamp);
            if (hMap.containsKey(exception)) {
                int frequency = hMap.get(exception);
                hMap.put(exception, frequency+1);
            } else {
                hMap.put(exception, 1);
            }
            map.put(timeStamp, hMap);
        }
        else{
            Map<String, Integer> hMap = new HashMap<>();
            hMap.put(exception, 1);
            map.put(timeStamp, hMap);
        }
    }
}
