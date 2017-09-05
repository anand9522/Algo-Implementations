package Graphs;
//
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by anand on 06/09/17.
 */
// #DFS, #ConnectedComponents
public class RoadsAndLibraries {

    private static HashMap<Integer, Node> integerNodeHashMap = new HashMap<>();
    private enum Status {NEW, VISITED};

    private static class Node{
        int nodeNumber;
        ArrayList<Node> nextNodes = new ArrayList<>();
        Status status=Status.NEW;
        public Node(int nodeNumber){
            this.nodeNumber=nodeNumber;
        }
    }

    public static void main(String[] args) {
        long answer;
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            answer=0;
            int n = in.nextInt();
            int m = in.nextInt();
            long x = in.nextLong();
            long y = in.nextLong();
            if (x<=y){
                answer=x*n;
                System.out.println(answer);
                continue;
            }
            for(int a1 = 0; a1 < m; a1++){
                int city_1 = in.nextInt();
                int city_2 = in.nextInt();
                if (!integerNodeHashMap.containsKey(city_1)){
                    integerNodeHashMap.put(city_1,new Node(city_1));
                }
                if (!integerNodeHashMap.containsKey(city_2)){
                    integerNodeHashMap.put(city_2,new Node(city_2));
                }

                integerNodeHashMap.get(city_1).nextNodes.add(integerNodeHashMap.get(city_2));
                integerNodeHashMap.get(city_2).nextNodes.add(integerNodeHashMap.get(city_1));
            }

            for (int node:integerNodeHashMap.keySet()){
               long currentRunNodes=DFS(integerNodeHashMap.get(node));;
                if (currentRunNodes!=0){
                    answer+=x+y*(currentRunNodes-1);
                }
            }
            System.out.println(answer);
            integerNodeHashMap.clear();
        }

    }

    private static long DFS(Node node){
        long count=0;
        if (node.status==Status.VISITED){
            return count;
        }
        count++;
        node.status=Status.VISITED;
        for (Node neighbour:node.nextNodes){
            count+=DFS(neighbour);
        }
        return count;
    }
}
