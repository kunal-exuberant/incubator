package likedriving.problemsolving.graph;

import java.util.*;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


class CloneGraph {

    public Node cloneGraph(Node node) {
        HashSet<Integer> visited = new HashSet<>();
        return cloneUtil(node, visited);
    }

    private Node cloneUtil(Node oldNode, HashSet<Integer> visited) {
        visited.add(oldNode.val);
        Node newNode = new Node(oldNode.val);
        for(int i=0; i< oldNode.neighbors.size(); i++) {
            if(!visited.contains(oldNode.neighbors.get(i).val)) {
                Node neighbor = cloneUtil(newNode.neighbors.get(i), visited);
                newNode.neighbors.add(neighbor);
            }
        }
        return newNode;
    }


    public Node cloneGraph1(Node node) {

        Node returnNode = null;
        // for referencing nodes using val
        HashMap<Integer, Node> refer = new HashMap<>();

        HashMap<Integer, List<Integer>> neighbors = new HashMap<>();

        HashSet<Integer> visited = new HashSet<>();

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()){
            Node visit = queue.poll();
            if(visit == null) return returnNode;
            visited.add(visit.val);

            Node newNode = new Node(visit.val);

            if(returnNode == null){
                returnNode = newNode;
            }

            refer.put(newNode.val, newNode);

            List<Integer> neighVals = new ArrayList<>();

            for(int i=0; i< visit.neighbors.size(); i++){
                neighVals.add(visit.neighbors.get(i).val);
                if(!visited.contains(visit.neighbors.get(i).val)){
                    queue.offer(visit.neighbors.get(i));
                }
            }
            neighbors.put(newNode.val, neighVals);
        }

        for(Map.Entry<Integer, Node> nodeEntry: refer.entrySet()){

            int vertex = nodeEntry.getKey();  //like 1, 2
            Node node1 = nodeEntry.getValue(); // Actual Node
            for(int i=0; i<neighbors.get(vertex).size(); i++){
                node1.neighbors.add(refer.get(neighbors.get(vertex).get(i)));
            }
        }

        return returnNode;
    }
}
