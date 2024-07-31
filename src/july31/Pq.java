package july31;

import java.util.PriorityQueue;

public class Pq {
    public static void main(String[] args) {
        int[] arr = {5, 1, 6, 8, 4, 9, 12, 10, 14};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : arr) {
            pq.add(i);
        }

        while (!pq.isEmpty()) {
            // System.out.print(pq.remove() + " ");
            System.out.print(pq.poll() + " ");
        }
    }
}
