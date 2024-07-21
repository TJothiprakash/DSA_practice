package Curious_Freaks.Recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintSequence {

    public static void main(String[] args) {
        PrintSequence printSequence = new PrintSequence();
        List<Integer> list = new ArrayList<>();
        list.add(16);
        list = printSequence.pattern(16 - 5, list);
        for (int i : list
        ) {
            System.out.print(i + " ");
        }

    }

    public List<Integer> pattern(int N, List<Integer> li) {
        // List<Integer> list = new ArrayList<>();
        if (N < 0) return li;


        li.add(N);
        return pattern(N - 5, li);

    }


}

class Solution03 {
    public List<Integer> pattern(int n) {
        List<Integer> result = new ArrayList<>();
        generatePattern(n, n, false, result);
        return result;
    }

    private void generatePattern(int current, int target, boolean increasing, List<Integer> result) {
        result.add(current);

        if (!increasing) {
            generatePattern(current - 5, target, current - 5 <= 0, result);
        } else {
            if (current + 5 <= target) {
                generatePattern(current + 5, target, true, result);
            }
        }
    }


}

