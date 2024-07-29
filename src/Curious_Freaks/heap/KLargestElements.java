package Curious_Freaks.heap;

import java.util.ArrayList;


public class KLargestElements {

    public static void main(String[] args) throws Exception {
        int[] arr = {1, 23, 12, 9, 30, 2, 50};
        int n = arr.length;
        int k = 3;

        int[] result = findKLargestElements(arr, n, k);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static int[] findKLargestElements(int[] arr, int n, int k) throws Exception {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        for (int num : arr) {
            maxHeap.insert(num);
        }

        int[] kLargest = new int[k];
        for (int i = 0; i < k; i++) {
            kLargest[i] = maxHeap.remove();
        }

        return kLargest;
    }

    static class MaxHeap<T extends Comparable<T>> {
        private final ArrayList<T> list;

        public MaxHeap() {
            list = new ArrayList<>();
        }

        private void swap(int first, int second) {
            T temp = list.get(first);
            list.set(first, list.get(second));
            list.set(second, temp);
        }

        private int parent(int index) {
            return (index - 1) / 2;
        }

        private int left(int index) {
            return index * 2 + 1;
        }

        private int right(int index) {
            return index * 2 + 2;
        }

        public void insert(T value) {
            list.add(value);
            upheap(list.size() - 1);
        }

        private void upheap(int index) {
            if (index == 0) {
                return;
            }
            int p = parent(index);
            if (list.get(index).compareTo(list.get(p)) > 0) { // Max-Heap condition
                swap(index, p);
                upheap(p);
            }
        }

        public T remove() throws Exception {
            if (list.isEmpty()) {
                throw new Exception("Removing from an empty heap!");
            }

            T temp = list.get(0);

            T last = list.remove(list.size() - 1);
            if (!list.isEmpty()) {
                list.set(0, last);
                downheap(0);
            }

            return temp;
        }

        private void downheap(int index) {
            int max = index;
            int left = left(index);
            int right = right(index);

            if (left < list.size() && list.get(max).compareTo(list.get(left)) < 0) { // Max-Heap condition
                max = left;
            }

            if (right < list.size() && list.get(max).compareTo(list.get(right)) < 0) { // Max-Heap condition
                max = right;
            }

            if (max != index) {
                swap(max, index);
                downheap(max);
            }
        }

        public ArrayList<T> heapSort() throws Exception {
            ArrayList<T> data = new ArrayList<>();
            while (!list.isEmpty()) {
                data.add(this.remove());
            }
            return data;
        }
    }
}
