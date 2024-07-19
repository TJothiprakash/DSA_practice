package Curious_Freaks.Arrays;

import java.util.Arrays;

public class Seiveoferanthoses {
    public static void main(String[] args) {
        int n = 13;
        System.out.println(new Seiveoferanthoses().sieve(n));

    }

    boolean sieve(int n) {
        boolean[] arr = new boolean[n + 1];
        int num = n + 1;
        Arrays.fill(arr, true);
        arr[0] = false;
        arr[1] = false;
        for (int i = 2; i * i <= num; i++) {
            if (arr[i]) {
                for (int j = i * i; j <= num; j += i) {
                    arr[j] = false;
                }
            }
        }
        return arr[n];
    }
}
