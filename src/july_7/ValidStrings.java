package july_7;

import java.util.ArrayList;
import java.util.List;

public class ValidStrings {

    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        ValidStrings validStrings = new ValidStrings();
        List<String> list = new ArrayList<>();
        list = sol.ValidStrings(3);
        for (String s : list
        ) {
            System.out.print(s + " ");
        }

    }

}

class Solution1 {

    public List<String> ValidStrings(int n) {
        List<String> result = new ArrayList<String>();
        generateValidSubstrings(n, "", result);
        return result;
    }

    public void generateValidSubstrings(int k, String s, List<String> result) {
        //base case
        if (s.length() == k) {
            result.add(s);
            return;

        }
        if (s.isEmpty()) {
            generateValidSubstrings(k, s + "1", result);
            generateValidSubstrings(k, s + "0", result);
        } else if (s.charAt(s.length() - 1) == '1') {
            generateValidSubstrings(k, s + "0", result);
            generateValidSubstrings(k, s + "1", result);
        } else if (s.charAt(s.length() - 1) == '0') {
            generateValidSubstrings(k, s + "1", result);

        }


    }
}