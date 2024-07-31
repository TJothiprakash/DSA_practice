package Curious_Freaks.graphs;

import java.util.*;

/*Given a Directed Graph with V vertices and E edges, Find the members of strongly connected components in the graph.

Note - Sort both the individual components and array of the components.

Example 1:

Input:

Output:
0 1 2,3,4,
Explanation:

We can clearly see that there are 3 Strongly
Connected Components in the Graph as mentioned
in the Output.
Example 2:

Input:

Output:
0 1 2,
Explanation:
All of the nodes are connected to each other.
So, there's only one SCC as shown.

Your Task:
You don't need to read input or print anything. Your task is to complete the function tarjans() which takes the number of vertices V and adjacency list of the graph as input parameters and returns a list of list of integers denoting the members of strongly connected components in the given graph.
Note: A single strongly connected component must be represented in the form of a list if integers sorted in the ascending order. The resulting list should consist of a list of all SCCs which must be sorted in a way such that a lexicographically smaller list of integers appears first.


Expected Time Complexity: O(V + E).
Expected Auxiliary Space: O(V).

*/
public class ConnectedComponent {


}


class Solution {
    private int time;
    private List<List<Integer>> sccs;
    private Stack<Integer> stack;
    private boolean[] inStack;
    private int[] ids, low;

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int V1 = 5;
        ArrayList<ArrayList<Integer>> adj1 = new ArrayList<>();
        for (int i = 0; i < V1; i++) {
            adj1.add(new ArrayList<>());
        }
        adj1.get(0).add(1);
        adj1.get(1).add(2);
        adj1.get(2).add(0);
        adj1.get(1).add(3);
        adj1.get(3).add(4);
        List<List<Integer>> sccs1 = sol.tarjans(V1, adj1);
        for (List<Integer> scc : sccs1) {
            System.out.println(scc);
        }

        // Example 2
        int V2 = 4;
        ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();
        for (int i = 0; i < V2; i++) {
            adj2.add(new ArrayList<>());
        }
        adj2.get(0).add(1);
        adj2.get(1).add(2);
        adj2.get(2).add(0);
        adj2.get(2).add(3);
        List<List<Integer>> sccs2 = sol.tarjans(V2, adj2);
        for (List<Integer> scc : sccs2) {
            System.out.println(scc);
        }
    }

    public List<List<Integer>> tarjans(int V, ArrayList<ArrayList<Integer>> adj) {
        time = 0;
        sccs = new ArrayList<>();
        stack = new Stack<>();
        inStack = new boolean[V];
        ids = new int[V];
        low = new int[V];
        Arrays.fill(ids, -1); // -1 means unvisited

        for (int i = 0; i < V; i++) {
            if (ids[i] == -1) {
                dfs(i, adj);
            }
        }

        // Sort each SCC and the list of SCCs
        for (List<Integer> scc : sccs) {
            Collections.sort(scc);
        }
        sccs.sort(Comparator.comparingInt(a -> a.get(0)));

        return sccs;
    }

    private void dfs(int at, ArrayList<ArrayList<Integer>> adj) {
        stack.push(at);
        inStack[at] = true;
        ids[at] = low[at] = time++;

        for (Integer to : adj.get(at)) {
            if (ids[to] == -1) {
                dfs(to, adj);
                low[at] = Math.min(low[at], low[to]);
            } else if (inStack[to]) {
                low[at] = Math.min(low[at], ids[to]);
            }
        }

        // On recursive callback, if we're at the root (start of SCC)
        if (ids[at] == low[at]) {
            List<Integer> scc = new ArrayList<>();
            while (true) {
                int node = stack.pop();
                inStack[node] = false;
                scc.add(node);
                low[node] = ids[at];
                if (node == at) break;
            }
            sccs.add(scc);
        }
    }
}
