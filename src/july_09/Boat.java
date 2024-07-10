package july_09;

public class Boat {
    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int[] arr = {3, 5, 3, 4};
        System.out.println(solution4.numRescueBoats(arr, 5));
    }

}


class Solution4 {
    public int numRescueBoats(int[] people, int limit) {
        int boat = 0;
        for (int i = 1; i < people.length; i++) {
            int sum = people[i] + people[i - 1];
            if (sum == limit) {
                boat++;
                i++;
            } else {
                boat++;
            }
        }
        return boat;
    }
}