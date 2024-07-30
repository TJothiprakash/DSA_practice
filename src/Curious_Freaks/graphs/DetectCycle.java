package Curious_Freaks.graphs;

import java.util.ArrayList;

public class DetectCycle {
    public static void main(String[] args) {

        int V = 10;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(4);
        adj.get(4).add(3);
        adj.get(4).add(5);
        adj.get(5).add(4);
        adj.get(5).add(6);
        adj.get(6).add(5);
        DetectCycle obj = new DetectCycle();
        System.out.println(obj.isCyclic(V, adj));
    }

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] visited = new int[V];
        int[] pathvisited = new int[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                if (dfscheck(i, adj, visited, pathvisited)) {
                    return true;
                }
            }

        }
        return false;
    }

    private boolean dfscheck(int i, ArrayList<ArrayList<Integer>> adj, int[] visited, int[] pathvisited) {
        visited[i] = 1;
        pathvisited[i] = 1;
        for (int k : adj.get(i)) {
            if (visited[k] == 0) {
                if (dfscheck(k, adj, visited, pathvisited)) {
                    return true;
                }
            } else if (pathvisited[k] == 1) {
                return true;
            }
        }
        pathvisited[i] = 0;
        return false;

    }
}
