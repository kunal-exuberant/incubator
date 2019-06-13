package likedriving.JavaFundamentals;

import org.junit.Test;

import java.util.*;
import java.util.function.DoubleToIntFunction;
import java.util.stream.Collectors;

public class Lambda {




    List<Integer> list = Arrays.asList(1,2,3,4,5,6,6,7,8);

    List<List> listOfList = Arrays.asList(list, Arrays.asList("a", "b","c"));




    Map<String, Integer> map = initMap();

    Map<String, Integer> initMap(){
        map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);

        return map;
    }

    // This is not available in java 8
   // Map<Integer, String> map1 = new Map.Entry(put(1,"a"));

    @Test
    public void printMapUsingLambda(){
        //map.forEach((x,y) -> System.out.println(x+" "+y));
       // map.entrySet().stream().forEach(System.out::println);
        List list1 = new ArrayList<>(map.entrySet());

        for(Object obj : list1){
            System.out.println(obj);
        }
    }






    @Test
    public void printListUsingLambda(){
        for(int a: list){
            System.out.println(a);
        }
    }

    @Test
    public void printListWithoutLambda(){
        //list.stream().forEach(a -> System.out.println(a));

         Object pick = listOfList.stream().flatMap(x -> x.stream()).collect(Collectors.toList());
        System.out.println(pick.toString());
        //opt.forEach(x -> System.out.println(x));
    }


    public static void main(String[] args) {

        DoubleToIntFunction doubleToIntFunction = (DoubleToIntFunction) a -> (int) a;

        //Greet greet =  name -> System.out.println("Hello"+ name);

        //Greet greet1 = () -> System.out.println("Hello world");

        Greet greetings = new Greet() {
            @Override
            public void sayHi() {
                System.out.println("Hello world in old way");
            }
        };

    }


    interface Greet{
        //void sayHello(String name);
        void sayHi();
    }
}
