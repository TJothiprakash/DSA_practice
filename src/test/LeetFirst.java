package test;

public class LeetFirst {
    public static void main(String[] args) {
        LeetFirst leetFirst = new LeetFirst();
        int[] arr = {0, 1, 0, 0, 1};
        int count = leetFirst.numberOfAlternatingGroups(arr);
        System.out.println("Number of alternating groups: " + count);
    }

    public int numberOfAlternatingGroups(int[] colors) {
        if (colors.length < 3) {
            return 0; // Not enough elements to form alternating groups
        }

        int counter = 0;
        int n = colors.length;

        for (int i = 0; i < n; i++) {

            if (colors[i] == 0 && colors[(i + 1) % n] == 1 && colors[(i + 2) % n] == 0) {
                counter++;
            }

            if (colors[i] == 1 && colors[(i + 1) % n] == 0 && colors[(i + 2) % n] == 1) {
                counter++;
            }
        }
        return counter;
    }
}
