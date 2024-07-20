package july_13;

public class LastDigit {
    public static void main(String[] args) {
        //System.out.println(getLastDigit("2", "3")); // Example usage
        // System.out.println(evenlyDivides(2446));
        //System.out.println(evenlyDivides(12));
        //System.out.println(reverse_digit(200));
        //System.out.println(reverse_digit(221));
        //System.out.println(power(12, 21));
        //System.out.println(gcd(3, 6));
        int a = 6, b = 3;
        System.out.println(a % b);
        System.out.println(b % a + " this is b%a");


    }

    static int getLastDigit(String a, String b) {
        int num1 = Integer.parseInt(a) % 10;
        if (num1 == 0) return 0;

        int num2 = Integer.parseInt(b);
        if (num2 == 0) return 1; // Any number to the power of 0 is 1

        int[] lastDigits = new int[4];
        lastDigits[0] = num1;

        for (int i = 1; i < 4; i++) {
            lastDigits[i] = (lastDigits[i - 1] * num1) % 10;
        }

        int cyclePosition = (num2 % 4 == 0) ? 3 : (num2 % 4) - 1;

        return lastDigits[cyclePosition];
    }

    static int evenlyDivides(int N) {
        int current = Math.abs(N);  // Consider the absolute value of N to handle negative numbers
        int count = 0;

        while (current > 0) {
            int temp = current % 10;
            if (temp != 0 && N % temp == 0) {  // Check if the digit is non-zero and evenly divides N
                count++;
            }
            current = current / 10;
        }
        return count;
    }

    public static long reverse_digit(long n) {
        // Code here
      /*  long temp = n;
        StringBuilder sb = new StringBuilder();

        while (temp > 0) {
            long t = temp % 10;
            if (t != 0) {  // Check if the digit is non-zero and evenly divides N
                sb.append(t);
            }
            temp = temp / 10;
        }
        return Long.parseLong(sb.toString());*/
        // Convert the number to a string
        String numStr = Long.toString(n);

        // Reverse the string
        StringBuilder reversed = new StringBuilder(numStr).reverse();

        // Skip leading zeros after reversing
        int i = 0;
        while (i < reversed.length() && reversed.charAt(i) == '0') {
            i++;
        }

        // Extract the non-zero part and convert it back to a number
        String reversedTrimmed = reversed.substring(i);
        if (reversedTrimmed.isEmpty()) {
            return 0;
        } else {
            return Long.parseLong(reversedTrimmed);
        }
    }

    static long power(int N, int R) {
        //Your code here
        long mod = 1000000007;
        long t = 1; // Initialize t to 1, as N^0 = 1

        while (R > 0) {
            t = (t * N) % mod; // Update t to be (t * N) % mod
            R--; // Decrease R for each iteration
        }

        return t;
    }
    /*class Solution {
    long power(int N, int R) {
        long mod = 1000000007;
        long result = 1;
        long base = N;

        while (R > 0) {
            if (R % 2 == 1) { // If R is odd, multiply base with result
                result = (result * base) % mod;
            }
            base = (base * base) % mod; // Square the base
            R /= 2; // Halve R
        }

        return result;
    }
}
*/


    public static int gcd(int a, int b) {
        // code here
        int ans = 0;
        for (int i = 1; i <= a; i++) {
            if (a % i == 0 && b % i == 0) {
                ans = i;
            }
        }
        return ans;
/*
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;*/
    }
}
