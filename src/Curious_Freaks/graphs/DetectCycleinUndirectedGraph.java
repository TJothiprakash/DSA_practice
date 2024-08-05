/*
package Curious_Freaks.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import java.util.ArrayList;


public class DetectCycleinUndirectedGraph {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int V = 4;
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(2).add(3);
        adj.get(3).add(2);
        DetectCycleinUndirectedGraph g = new DetectCycleinUndirectedGraph();
        System.out.println(g.isCycle(V, adj));


        System.out.println(g.isCycleusebfs(V, adj));

    }

    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfscheck(i, adj, visited, -1)) {
                    return true;
                }
            }
        }
        return false;

    }

    private boolean dfscheck(int i, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int parent) {
        visited[i] = true;

        for (int n : adj.get(i)) {
            if (!visited[n]) {
                if (dfscheck(n, adj, visited, i)) {
                    return true;
                }

            } else if (n != parent) {
                return true;

            }
        }
        return false;
    }


    public boolean isCycleusebfs(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfscheck(i, adj, visited, -1)) {
                    return true;
                }
            }
        }
        return false;

    }

    private boolean bfscheck(int i, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int parent) {

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair(i, -1));
        visited[i] = true;
        while (!q.isEmpty()) {
            int node = q.peek().getKey();
            int par = q.peek().getValue();
            q.remove();
            for (int j : adj.get(node)) {
                if (!visited[j]) {
                    q.add(new Pair<>(j, node));
                    visited[j] = true;
                } else if (j != par) {
                    return true;
                }
            }

        }
        return false;
    }

}
*/
