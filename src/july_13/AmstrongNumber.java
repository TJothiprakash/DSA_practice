package july_13;

public class AmstrongNumber {
    public static void main(String[] args) {
        System.out.println(armstrongNumber(15));
    }

    static String armstrongNumber(int n) {
        // code here
        String str = Integer.toString(n);
        int len = str.length();
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += Math.pow(Integer.parseInt(str.charAt(i) + ""), len);
        }
        if (sum == n)
            return "Yes";
        return "No";
    }

    static int isPerfectNumber(long N) {
        // code here
        int sum = 0;
        for (int i = 1; i < N; i++) {
            if (N % i == 0) {
                sum += i;
            }
        }
        if (sum == N)
            return 1;
        return 0;
    }

    // Your code here

    public String is_palindrome(int n) {
        // Code here
        String str = Integer.toString(n);
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1))
                return "true";
        }
        return "false";
    }

    long floorSqrt(long x) {
        // Base cases
        if (x == 0 || x == 1)
            return x;

        long start = 1, end = x, ans = 0;

        while (start <= end) {
            long mid = (start + end) / 2;

            // If mid*mid is less than or equal to x, then mid is a candidate
            if (mid * mid <= x) {
                ans = mid;
                start = mid + 1;
            } else {
                // If mid*mid is greater than x, then mid is too large, search left
                end = mid - 1;
            }
        }

        return ans;
    }

}
