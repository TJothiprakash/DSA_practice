package Curious_Freaks.BinarySearch;
/*
public class KoKoBananas {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int h = 5;
        int ans = minEatingSpeed(arr, h);
        System.out.println("The minimum eating speed is: " + ans);
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);

        }

        for (int i = 1; i <= max; i++) {
            int requireTime = 0;
            requireTime = function(piles, i);
            if (requireTime <= h) {
                return i;
            }
        }
        return -1;
    }

    private static int function(int[] piles, int i) {
        int sum = 0;
        for (int j = 0; j < piles.length; j++) {
            sum += Math.ceil(piles[j] / i);
            if (piles[j] % i != 0) {
                sum++;
            }
        }
        return sum;
    }
}
*/

public class KoKoBananas {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int h = 5;
        int ans = minEatingSpeed(arr, h);
        System.out.println("The minimum eating speed is: " + ans);
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int left = 1;
        int right = max;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, mid, h)) {
                right = mid; // Try to find a smaller valid speed
            } else {
                left = mid + 1; // Increase the speed
            }
        }
        return left;
    }

    private static boolean canFinish(int[] piles, int speed, int h) {
        int time = 0;
        for (int pile : piles) {
            time += (pile + speed - 1) / speed; // This is equivalent to Math.ceil(pile / speed)
        }
        return time <= h;
    }
}
