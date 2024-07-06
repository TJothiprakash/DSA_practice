package july_04;

public class FirstAndLastOccurrance {
    public static void main(String[] args) {
        FirstAndLastOccurrance firstAndLastOccurrance = new FirstAndLastOccurrance();
        int[] arr = {1, 2, 3,3,3,3,3, 4, 5, 5, 5, 5, 5, 6, 7, 7, 8};
        //   int[] test = firstAndLastOccurrence.findOccurrences(arr, 7);
        //for (int t : test) {
        //  System.out.print(t + " ");
        int left = firstAndLastOccurrance.firstoccurrence(arr,3);
        int rigt= firstAndLastOccurrance.lastOccurrence(arr,3);
        System.out.println(left+" "+ rigt);
    }

    int firstoccurrence(int[] arr, int target) {
        int ans = arr.length;
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return ans;
    }


int lastOccurrence(int []arr,int target){
        int ans=arr.length;
    int left = 0, right = arr.length - 1;

    while (left <= right) {
        int mid = (left + right) / 2;
        if (arr[mid] > target) {
            ans = mid;
            right = mid - 1;
        } else {
            left = mid + 1;
        }

    }

        return ans-1;
}




/*
    int[] findOccurrences(int[] arr, int target) {
        int[] ans = new int[2];
        int first = -1, last = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                if (first == -1) first = i;

                last = i;
            }

        }
        return new int[]{first, last};

    }
*/
}
