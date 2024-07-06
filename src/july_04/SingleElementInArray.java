package july_04;

public class SingleElementInArray {
    public static void main(String[] args) {
        SingleElementInArray singleElementInArray = new SingleElementInArray();
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7};
        int res = singleElementInArray.searchSingleElement(arr);
        System.out.println(res + " hl ");
    }

    int searchSingleElement(int[] arr) {
        int ans = -1;

        if (arr.length == 1) {
            return arr[0];
        }

        if (arr[0] != arr[1]) {
            return arr[0];
        }

        if (arr[arr.length - 1] != arr[arr.length - 2]) {
            return arr[arr.length - 1];
        }

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] != arr[i - 1] && arr[i] != arr[i + 1]) {
                ans = arr[i];
                break;
            }
        }

        return ans;
    }
}
