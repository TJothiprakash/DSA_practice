package Curious_Freaks.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class DijkstrasUsingSet {
    // Function to find the shortest distance of all the vertices
    // from the source vertex S.
    public int[] dijkstra(int V, ArrayList<int[]>[] adj, int S) {
        // Create a TreeSet to store the nodes as pairs {dist, node}
        // TreeSet stores the nodes in ascending order of the distances
        TreeSet<int[]> st = new TreeSet<>(Comparator.comparingInt(a -> a[0]));

        // Initialize dist array with a large number to indicate unvisited nodes initially.
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Insert the source node with distance 0.
        st.add(new int[]{0, S});
        dist[S] = 0;

        // Now, remove the minimum distance node first from the set
        // and traverse for all its adjacent nodes.
        while (!st.isEmpty()) {
            int[] nodeInfo = st.pollFirst();
            int node = nodeInfo[1];
            int dis = nodeInfo[0];

            // Check for all adjacent nodes of the removed element
            // whether the previous dist is larger than current or not.
            for (int[] it : adj[node]) {
                int adjNode = it[0];
                int edgW = it[1];

                if (dis + edgW < dist[adjNode]) {
                    // Remove if it was visited previously at a greater cost.
                    if (dist[adjNode] != Integer.MAX_VALUE) {
                        st.remove(new int[]{dist[adjNode], adjNode});
                    }

                    // If current distance is smaller, update it
                    // and push into the TreeSet.
                    dist[adjNode] = dis + edgW;
                    st.add(new int[]{dist[adjNode], adjNode});
                }
            }
        }
        // Return the array containing shortest distances from source to all the nodes.
        return dist;
    }
}

class MainCLass {
    public static void main(String[] args) {
        // Driver code
        int V = 3, E = 6, S = 2;
        ArrayList<int[]>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        // Constructing the adjacency list
        adj[0].add(new int[]{1, 1});
        adj[0].add(new int[]{2, 6});
        adj[1].add(new int[]{2, 3});
        adj[1].add(new int[]{0, 1});
        adj[2].add(new int[]{1, 3});
        adj[2].add(new int[]{0, 6});

        DijkstrasUsingSet obj = new DijkstrasUsingSet();
        int[] res = obj.dijkstra(V, adj, S);

        // Printing the shortest distances from source S
        for (int i = 0; i < V; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}

/*

public class DijkstrasUsingSet {
    // Function to find the shortest distance of all the vertices
    // from the source vertex S.
    public int[] dijkstra(int V, ArrayList<ArrayList<int[]>> adj, int S) {
        // Create a priority queue (min-heap) to store nodes as {dist, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // Initialize distance array with a large number to indicate unvisited nodes.
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Priority queue initialization with source node S having distance 0.
        pq.offer(new int[]{0, S});
        dist[S] = 0;

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int node = top[1];
            int dis = top[0];

            // Iterate through all adjacent nodes of the current node.
            for (int[] neighbor : adj.get(node)) {
                int adjNode = neighbor[0];
                int edgeWeight = neighbor[1];

                // If a shorter path to adjNode is found through node,
                // update dist and push into the priority queue.
                if (dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight;
                    pq.offer(new int[]{dist[adjNode], adjNode});
                }
            }
        }
        return dist;
    }
}

class main {
    public static void main(String[] args) {
        // Driver code
        int V = 3, E = 6, S = 2;
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Constructing the adjacency list
        adj.get(0).add(new int[]{1, 1});
        adj.get(0).add(new int[]{2, 6});
        adj.get(1).add(new int[]{2, 3});
        adj.get(1).add(new int[]{0, 1});
        adj.get(2).add(new int[]{1, 3});
        adj.get(2).add(new int[]{0, 6});

        DijkstrasUsingSet obj = new DijkstrasUsingSet();
        int[] res = obj.dijkstra(V, adj, S);

        // Printing the shortest distances from source S
        for (int i = 0; i < V; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}
*/
