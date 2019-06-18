package likedriving.design.DestinationStore;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import likedriving.TechStacks.Redis.RedisClient;
import likedriving.TechStacks.Redis.RedisConfiguration;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RedisOperations {

    private static String appkey = "glimpse";

    private static String idKey = "destinationId";

    private static Jedis jedis = RedisClient.getConnection(new RedisConfiguration());

    public static int loadDestinationId(){
        if(jedis.exists(idKey)) {
            return Integer.parseInt(jedis.get(idKey));
        }
        return 0;
    }

    public static void commit() throws JsonProcessingException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        String stringObject = objectMapper.writeValueAsString(DestinationStore.destinationStore);

        jedis.set(appkey, stringObject);
        jedis.set(idKey, String.valueOf(Destination.DESTINATION_ID));
        jedis.close();
    }

    public static void load() throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        if(jedis.exists(appkey)) {
            String destinationString = jedis.get(appkey);
            if(destinationString != "") {
                DestinationStore.destinationStore = objectMapper.readValue(destinationString, new TypeReference<ArrayList<Destination>>() {});
            }
        }
    }


    @Test
    public void test() throws JsonProcessingException, IOException {
        //  Jedis jedis = RedisClient.getConnection(new RedisConfiguration());

        ObjectMapper objectMapper = new ObjectMapper();

        Destination destination1 = new Destination(1, "Ladhaak", "Lakhaak is a beautiful place", null);
        Destination destination2 = new Destination(2, "Munnar", "Munnar is a beanutiful place", null);
        List<Destination> destinationList1 = Arrays.asList(destination1, destination2);

        String str = objectMapper.writeValueAsString(destinationList1);
        List<Destination> destinationList2 = objectMapper.readValue(str, new TypeReference<ArrayList<Destination>>(){});

        System.out.println(destinationList2);
        System.out.println(destinationList2.get(0).getName());
    }
}
