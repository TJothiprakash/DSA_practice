package july_13;

public class MinandMax {
    public static void main(String[] args) {
        int[] arr = {32, 53, 1, 857, 3463, 7657658, 34, 34, 75, 453, 64};
        System.out.print("Given array is:  ");
        System.out.println("elements in array: ");
        System.out.println(search(arr, 1));
        for (int i : arr
        ) {
            System.out.print(i + " ");

        }
        System.out.println();
        Pair<Long, Long> pair = getMinMax(arr);
        System.out.println("Min value " + pair.getKey() + ", Max value " + pair.getValue());
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Find the middle point
            int mid = (left + right) / 2;

            // Recursively sort first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        // Sizes of two subarrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temporary arrays
        System.arraycopy(arr, left, leftArray, 0, n1);
        for (int j = 0; j < n2; ++j)
            rightArray[j] = arr[mid + 1 + j];

        // Merge the temporary arrays
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray[], if any
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray[], if any
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static Pair<Long, Long> getMinMax(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
        long min = arr[0];
        long max = arr[arr.length - 1];
        return new Pair<>(min, max);
    }

    static int search(int[] arr, int x) {
        int ans = 0;
        boolean status = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                ans = i;
                status = true;
                break;
            }
        }
        if (status) {
            return ans;
        } else {
            return -1;
        }
    }

}

class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }


    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}