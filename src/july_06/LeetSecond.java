package july_06;
class LeetFirst1 {
    public static void main(String[] args) {
        LeetFirst1 leetFirst = new LeetFirst1();
        int[] colors1 = {0, 1, 0, 1, 0};
        int k1 = 3;
        int count1 = leetFirst.numberOfAlternatingGroups(colors1, k1);
        System.out.println("Number of alternating groups: " + count1); // Output: 3

        int[] colors2 = {0, 1, 0, 0, 1, 0, 1};
        int k2 = 6;
        int count2 = leetFirst.numberOfAlternatingGroups(colors2, k2);
        System.out.println("Number of alternating groups: " + count2); // Output: 2
    }

    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        if (n < k) {
            return 0; // Not enough elements to form a group of length k
        }

        int counter = 0;

        // Iterate through each possible starting point in the array
        for (int i = 0; i < n; i++) {
            boolean isAlternating = true;

            // Check the k-length window starting at index i
            for (int j = 0; j < k - 1; j++) {
                if (colors[(i + j) % n] == colors[(i + j + 1) % n]) {
                    isAlternating = false;
                    break;
                }
            }

            if (isAlternating) {
                counter++;
            }
        }
        return counter;
    }
}
