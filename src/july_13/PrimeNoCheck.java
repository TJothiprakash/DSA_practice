package july_13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrimeNoCheck {
    public static void main(String[] args) {
        int n = 14; // Example number to check
        List<Integer> divisors = findDivisorsAndCheckPrime(n);
        System.out.println("Divisors of " + n + ": " + divisors);
    }

    public static List<Integer> findDivisorsAndCheckPrime(int x) {
        List<Integer> divisors = findDivisors(x);
        boolean isPrime = isPrime(x, divisors);
        System.out.println(x + (isPrime ? " is Prime" : " is Not Prime"));
        return divisors;
    }

    public static List<Integer> findDivisors(int x) {
        List<Integer> divisors = new ArrayList<>();
        int sqrtX = (int) Math.sqrt(x);
        for (int i = 1; i <= sqrtX; i++) {
            if (x % i == 0) {
                divisors.add(i);
                if (i != x / i && i != 1) {
                    divisors.add(x / i);
                }
            }
        }
        Collections.sort(divisors);
        return divisors;
    }

    public static boolean isPrime(int x, List<Integer> divisors) {
        if (x <= 1) {
            return false;
        }
        for (int d : divisors) {
            if (d != 1 && d != x && x % d == 0) {
                return false;
            }
        }
        return true;
    }
}
