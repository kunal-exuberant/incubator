package likedriving.TechStacks.Redis;

import redis.clients.jedis.Jedis;

import java.util.*;

public class RedisClient {

    private static Jedis jedis = null;

    public static Jedis getConnection(RedisConfiguration configuration){
        //Connecting to Redis on localhost
        jedis = new Jedis("localhost");
        return jedis;
    }

    public static void main(String[] args) throws InterruptedException {

        getConnection(new RedisConfiguration());
        jedis.set("key", "value");
        System.out.println(jedis.get("key"));

        jedis.set("name", "kunal");
        expireKey("name");

        System.out.println("\n************* SET *******************");

        storingSet();

        System.out.println("\n************* MAP *******************");
        storingMap();

        System.out.println("\n************* LIST *******************");
        storingList();

        closeConnection();

    }

    private static void storingList() {

        String [] names = new String[3];
        names[0] = "vishnu";
        names[1] = "lakshmikant";
        names[2] = "kesav";

        jedis.lpush("names", names);

        jedis.lpush("names", names );

        System.out.println(jedis.lpop("names"));

        System.out.println(jedis.rpop("names"));

        System.out.println(jedis.lindex("names", 2));

        System.out.println(jedis.ping("This is kunal here"));

        printAllKeys();


    }

    static void printAllKeys(){
        System.out.println("Following are the list of all keys of redis");
        Set<String> keys = jedis.keys("*");
        for(String key: keys){
            System.out.println(key);
        }
    }

    static void storingMap(){

        String key = "simpleMap";

        Map<String, String> map = new HashMap<>();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");
        map.put("d", "4");

        jedis.hmset(key, map);

        // Getting a single key value from the map
        System.out.println(jedis.hmget(key, "b", "c"));

        System.out.println(jedis.hget(key, "a"));

        // Fetching the entire map

        System.out.println(jedis.hgetAll(key));
    }

    static void storingSet(){

        String key = "techStacks";

        String [] values = {"Java", "Redis", "Elastic Search", "Kafka", "Apache Storm"};

        jedis.sadd(key, values);

        System.out.println(jedis.smembers(key));

    }

    static void expireKey(String key) throws InterruptedException{

        System.out.println(jedis.get("name"));
        jedis.expire("name", 1);
        Thread.sleep(1000);
        System.out.println("Unable to fetch value as it expired: "+jedis.get("name"));

    }

    static void closeConnection(){

        jedis.close();
        jedis.lpush("x","y");
    }

}
