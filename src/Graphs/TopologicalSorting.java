package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by anand on 01/09/17.
 */
public class TopologicalSorting {
    private enum Status {VISITED, VISITING, NEW}

    public Map<Integer, Node> integerNodeMap = new HashMap<>();
    private class Node{
         int nodeNumber=-1;
         ArrayList<Node> nextNodes = new ArrayList<>();
         Status status=Status.NEW;
    }

    public ArrayList<Integer> getTopologicalSorting(){
        ArrayList<Integer> topologicalOrder = new ArrayList<>();
        for (int node : integerNodeMap.keySet()) {
            if (topologicalDFS(integerNodeMap.get(node),topologicalOrder)==-1){
                return new ArrayList<>();
            }
        }
        return topologicalOrder;
    }

    private int topologicalDFS(Node node, List<Integer> topologicalSort){
        if (node.status == Status.VISITING){
            return -1;
        }
        else if (node.status == Status.VISITED){
            return 1;
        }
        else if (node.status == Status.NEW){
            node.status = Status.VISITING;
            for (Node nextNode:node.nextNodes){
                if (topologicalDFS(node,topologicalSort)==-1){
                    return -1;
                }
                topologicalSort.add(nextNode.nodeNumber);
            }
            node.status=Status.VISITED;
        }
        return 1;
    }

}
