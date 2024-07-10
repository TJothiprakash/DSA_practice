package july_10;


public class Subsequence {
    public static void main(String[] args) {
        Main main = new Main();
        int[] array = {1, 2, 3};
        Main.printSubsequences(array, 0, new StringBuilder());

    }


}

class Main {

    public static void printSubsequences(int[] array, int index, StringBuilder current) {
        if (index == array.length) {
            if (current.length() > 0) {
                System.out.println(current); // Print the current subsequence
            }
            return;
        }

        // Include the current element
        current.append(array[index]);
        printSubsequences(array, index + 1, current);

        // Exclude the current element and backtrack
        current.deleteCharAt(current.length() - 1);
        printSubsequences(array, index + 1, current);
    }
}
