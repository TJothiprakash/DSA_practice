package july_09;

public class StringAAA {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int a = 3;
        int b = 4;
        String result = solution.strWithout3a3b(a, b);
        System.out.println(result);
    }
}

class Solution1 {
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();
        int length = a + b;

        // Generate the string
        generateString(sb, a, b);

        return sb.toString();
    }

    private void generateString(StringBuilder sb, int a, int b) {
        // Base case: if both a and b are 0, return
        if (a == 0 && b == 0) return;

        // Case 1: if a > b and a > 1, add "aa"
        if (a > b && a > 1) {
            sb.append("aa");
            generateString(sb, a - 2, b);
        }
        // Case 2: if b > a and b > 1, add "bb"
        else if (b > a && b > 1) {
            sb.append("bb");
            generateString(sb, a, b - 2);
        }
        // Case 3: if a == b or one of them is 1, add "ab" or "ba"
        else {
            sb.append(a > 0 ? "a" : "b");
            generateString(sb, a > 0 ? a - 1 : a, b > 0 ? b - 1 : b);
        }
    }
    /*public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();
        int countA = 0, countB = 0;

        while (a > 0 || b > 0) {
            if (a > b) {
                if (countA < 2) {
                    sb.append('a');
                    a--;
                    countA++;
                    countB = 0;
                } else {
                    sb.append('b');
                    b--;
                    countB++;
                    countA = 0;
                }
            } else if (b > a) {
                if (countB < 2) {
                    sb.append('b');
                    b--;
                    countB++;
                    countA = 0;
                } else {
                    sb.append('a');
                    a--;
                    countA++;
                    countB = 0;
                }
            } else {
                if (countA < 2) {
                    sb.append('a');
                    a--;
                    countA++;
                    countB = 0;
                } else if (countB < 2) {
                    sb.append('b');
                    b--;
                    countB++;
                    countA = 0;
                }
            }
        }

        return sb.toString();
    }*/
}
