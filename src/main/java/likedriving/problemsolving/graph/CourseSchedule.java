package likedriving.problemsolving.graph;

import com.hazelcast.collection.ISet;

import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
    /*    int [] [] p = {{1,4},{2,4},{3,1},{3,2}};
        System.out.println(new CourseSchedule().canFinish(5, p));
        ArrayList<Integer>[] x = new ArrayList[10];*/

        Set<int []> set = new HashSet<>();

        int [] x = {1, 2};
        int [] y = {1,2,3};
        int [] p = {1, 2};
        set.add(x);
        set.add(y);
        for(int [] a: set) {
            if(set.contains(p)) {
                Arrays.stream(a).forEach(System.out::println);
            }
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return true;
        if (prerequisites.length == 0) return true;

        Map<Integer, ArrayList<Integer>> cd = new HashMap<>();

        for(int i=0; i<numCourses; i++){
            cd.put(i, new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            arr = cd.getOrDefault(prerequisites[i][0], arr);
            arr.add(prerequisites[i][1]);

            cd.put(prerequisites[i][0], arr);

            cd.put(prerequisites[i][1], cd.getOrDefault(prerequisites[i][1], new ArrayList<>()));
        }

        Queue<Map.Entry<Integer, ArrayList<Integer>>> courses = new LinkedList<>();
        HashSet<Map.Entry<Integer, ArrayList<Integer>>> visited = new HashSet<>();

        for (Map.Entry<Integer, ArrayList<Integer>> ce : cd.entrySet()) {
            if (ce.getValue().size() == 0) {
                courses.offer(ce);
                visited.add(ce);
            }
        }

        while (!courses.isEmpty()){
            Map.Entry<Integer, ArrayList<Integer>> course = courses.poll();
            for (Map.Entry<Integer, ArrayList<Integer>> ce1 : cd.entrySet()) {
                ce1.getValue().remove(course.getKey());
                if(ce1.getValue().size() == 0 && !visited.contains(ce1)){
                    courses.offer(ce1);
                    visited.add(ce1);
                }
            }
        }

        for (Map.Entry<Integer, ArrayList<Integer>> ce : cd.entrySet()) {
            if (ce.getValue().size() == 0) {
                numCourses--;
                if (numCourses == 0) return true;
            }
        }
        return false;
    }
}
