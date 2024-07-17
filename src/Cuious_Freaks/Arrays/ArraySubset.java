package Cuious_Freaks.Arrays;

import java.util.HashSet;
import java.util.Set;

public class ArraySubset {
    public static void main(String[] args) {

        ArraySubset arraySubset = new ArraySubset();
        long[] a1 = {1, 2, 3, 4, 5};
        long[] a2 = {1, 7, 3};
        long n = 5;
        long m = 3;
        System.out.println(arraySubset.isSubset(a1, a2, n, m));
    }

    public String isSubset(long[] a1, long[] a2, long n, long m) {
        Set<Long> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(a1[i]);
        }
        for (int j = 0; j < m; j++) {
            if (!set.contains(a2[j])) {
                return "No";
            }
        }
        return "Yes";
    }
}

