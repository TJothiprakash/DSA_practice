package Curious_Freaks.dynamic_programming;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution05 {
    // Helper method to perform DFS with memoization
    private int dfs(int current, int destination, Map<Integer, List<Integer>> graph, Map<Integer, Integer> memo) {
        // Base case: if we have reached the destination
        if (current == destination) {
            return 1;
        }

        // If we have already computed the number of ways from this node
        if (memo.containsKey(current)) {
            return memo.get(current);
        }

        // Initialize the count of ways from the current node
        int count = 0;

        // Explore all adjacent nodes
        if (graph.containsKey(current)) {
            for (int neighbor : graph.get(current)) {
                count += dfs(neighbor, destination, graph, memo);
            }
        }

        // Memoize and return the count
        memo.put(current, count);
        return count;
    }

    public int possible_paths(int[][] edges, int n, int start, int destination) {
        // Create the graph using adjacency list representation
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
        }

        // Map to store the number of ways from each node
        Map<Integer, Integer> memo = new HashMap<>();

        // Start DFS from the start node
        return dfs(start, destination, graph, memo);
    }
}

public class DAGuniqupaths {
}
