package Curious_Freaks.graphs;

import java.util.ArrayList;

public class DFS {
    public static void main(String[] args) {

        int V = 7;
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
        ArrayList<Integer> ans = new DFS().dfsOfGraph(V, adj);
        for (int k :
                ans) {
            System.out.print(k + " ");
        }
    }

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V + 1];
        ArrayList<Integer> list = new ArrayList<>();

        //visited[0] = true;

        visited[0] = true;

        dfs(0, visited, adj, list);
        return list;
    }

    private void dfs(int i, boolean[] visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> list) {
        visited[i] = true;
        list.add(i);
        for (int j : adj.get(i)) {
            if (!visited[j]) {
                dfs(j, visited, adj, list);
            }
        }
    }

}
