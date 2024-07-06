import java.util.ArrayList;

public class RecursionSubsequence {
/*
    public static void main(String[] args) {
        int arr[] = {1, 2,7,6, 1,3,1,2};
        int n = 8;
        int sum = 7;
        ArrayList<Integer> ds = new ArrayList<>();
        printAns(0, ds, 0, n, arr, sum);
    }

    private static void printAns(int i, ArrayList<Integer> ds, int s, int n, int[] arr, int sum) {
        if (i == n) {
            if (s == sum) {
                for (int j : ds) {
                    System.out.print(j + " ");
                }
                System.out.println();

            }
            return;
        }
        ds.add(arr[i]);
        s += arr[i];
        printAns(i + 1, ds, s, n, arr, sum);
        s -= arr[i];
        ds.remove(ds.size() - 1);
        printAns(i + 1, ds, s, n, arr, sum);

    }*/

        public static void main(String[] args) {
            int arr[] = {1, 2, 7, 6, 1, 3, 1, 2};
            int n = arr.length;
            int sum = 7;
            ArrayList<Integer> ds = new ArrayList<>();
            printAns(0, ds, 0, n, arr, sum);
        }

        private static void printAns(int i, ArrayList<Integer> ds, int s, int n, int[] arr, int sum) {
            if (i == n) {
                if (s == sum) {
                    for (int j : ds) {
                        System.out.print(j + " ");
                    }
                    System.out.println();
                }
                return;
            }

            // Include the current element
            ds.add(arr[i]);
            s += arr[i];
            printAns(i + 1, ds, s, n, arr, sum);

            // Exclude the current element
            s -= arr[i];
            ds.remove(ds.size() - 1);
            printAns(i + 1, ds, s, n, arr, sum);
        }
    }


