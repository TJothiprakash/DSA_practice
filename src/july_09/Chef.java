package july_09;

import org.jetbrains.annotations.NotNull;

public class Chef {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] test = {{1, 2}, {2, 5}};
        // System.out.println(test[0]+" " +test[1]);
        System.out.println(solution.averageWaitingTime(test));
    }
}

class Solution {
    public double averageWaitingTime(int[] @NotNull [] customers) {
        double total_waiting_time = 0;
        int current_time = 0;

        for (int[] customer : customers) {
            int arrival = customer[0];
            int service = customer[1];
            if (arrival > current_time) {
                current_time = arrival;
            }
            int waiting_time = current_time - arrival + service;
            total_waiting_time += waiting_time;
            current_time += service;
        }

        return total_waiting_time / customers.length;
    }
}