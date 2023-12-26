package likedriving.problemsolving.graph;

import java.util.*;
public class PacificAtlanticOceanWaterFlow {

    public static void main(String[] args) {
        int [][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        List<List<Integer>> result = pacificAtlantic(heights);
        result.forEach(System.out::println);
/*        Set<List<Integer>> pacific = new HashSet<>();
        List x = Arrays.asList(0,1);
        pacific.add(x);
        ArrayList y = new ArrayList<>();
        y.add(0); y.add(1);
        if (pacific.contains(y)){
            System.out.println(x);
        }*/
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> result = new ArrayList<>();

        int m = heights.length;
        if(m ==0) return result;
        int n = heights[0].length;

        int [] neighboursX = {-1, 0, 1, 0};
        int [] neighboursY = {0, -1, 0, 1};

        Set<List<Integer>> pacific = new HashSet<>();
        Set<List<Integer>> atlantic = new HashSet<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i ==0 || j == 0) pacific.add(Arrays.asList(i,j));
                if(i == m-1 || j == n-1) atlantic.add(Arrays.asList(i,j));
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                List<Integer> current = Arrays.asList(i,j);
                if(pacific.contains(current) && atlantic.contains(current)){
                    result.add(current);
                    //System.out.println("result: "+result);
                }
                else{
                    Set<List<Integer>> visited = new HashSet<>();
                    Queue<List<Integer>> neighbours = new LinkedList<>();
                    neighbours.offer(current);
                    //System.out.println("else: "+current);
                    boolean pacificFlow = false, atlanticFlow = false, canFlow = false;
                    while(!neighbours.isEmpty()){
                        List<Integer> node = neighbours.poll();
                        //System.out.println(node);
                        for(int p=0; p<4; p++){
                                if(node.get(0) + neighboursX[p] >=0 && node.get(0)+neighboursX[p] < m && node.get(1)+neighboursY[p] >=0 && node.get(1)+neighboursY[p] < n){
                                    List<Integer> neighbour = new ArrayList<>();
                                    neighbour.add(node.get(0)+neighboursX[p]); neighbour.add(node.get(1)+neighboursY[p]);
                                    if(!visited.contains(neighbour)){
                                        if(heights[node.get(0)][node.get(1)] >= heights[neighbour.get(0)][neighbour.get(1)]){
                                            visited.add(neighbour);
                                            //System.out.println(neighbour);
                                            if(pacific.contains(neighbour)) pacificFlow = true;
                                            if(atlantic.contains(neighbour)) atlanticFlow = true;

                                            if(pacificFlow && atlanticFlow){
                                                result.add(current);
                                                canFlow = true;
                                                break;
                                            }
                                            neighbours.offer(neighbour);
                                            //System.out.println("add: "+neighbour);
                                        }
                                    }
                            }
                            if(canFlow) break;
                        }
                        if(canFlow) break;
                    }
                }
            }
        }
        return result;
    }
}
