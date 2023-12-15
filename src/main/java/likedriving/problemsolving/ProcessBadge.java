package likedriving.problemsolving;



/*CODING:

We are working on a security system for a badged-access room in our company's building.

Given an ordered list of employees who used their badge to enter or exit the room, write a function that returns two collections:

1. All employees who didn't use their badge while exiting the room – they recorded an enter without a matching exit.
2. All employees who didn't use their badge while entering the room – they recorded an exit without a matching enter.

Sample input:
badge_records = [
["Martha", "exit"],
["Paul", "enter"],
["Martha", "enter"],
["Martha", "exit"],
["Jennifer", "enter"],
["Paul", "enter"],
["Curtis", "enter"],
["Paul", "exit"],
["Martha", "enter"],
["Martha", "exit"],
["Jennifer", "exit"],
]

Sample output:
["Paul", "Curtis"], ["Martha"]
*/


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ProcessBadge{
    public static void main(String [] args){

        ArrayList<ArrayList<String>> badge_records = new ArrayList<>();

        ArrayList<String> lst = new ArrayList<>();
        lst.add("Martha");
        lst.add("exit");

        badge_records.add(lst);
        processBadge(badge_records);


    }

    public static void processBadge(ArrayList<ArrayList<String>> badge_records){

        HashSet<String> woEntry = new HashSet<>();
        HashSet<String> woExit = new HashSet<>();

        Map<String, Integer> enterExits = new HashMap<>();
        for(ArrayList<String> badge_record: badge_records){
            if(enterExits.containsKey(badge_record.get(0))){
                int increment = 1;
                if(badge_record.get(1).equals("exit")) {
                    increment = -1;
                }
                enterExits.put(badge_record.get(0), enterExits.getOrDefault(badge_record.get(0), 0) + increment);
                if(enterExits.get(badge_record.get(1)) >1 ){
                    woExit.add(badge_record.get(0));
                }
                else if(enterExits.get(badge_record.get(1)) < 0){
                    woEntry.add(badge_record.get(0));
                }
            }
            else{
/*                if(enterExits.get(badge_record.get(0) == "exit")){
                    woEntry.add(enterExits.getKey());
                    break;
                }*/
            }
        }

        for(Map.Entry<String, Integer> entry: enterExits.entrySet()){

            if(entry.getValue() >1 ){
                //woExit.add(enterExits.getKey());
            }
            else if(entry.getValue() < 0){
                //woEntry.add(enterExits.getKey());
            }
        }


        for(String s: woExit){
            System.out.println(s);
        }

        for(String s: woEntry){
            System.out.println(s);
        }


    }
}


