package test;

import org.jetbrains.annotations.Contract;

public class ArithmeticTriplets {


    //bruteforce method
    /*
        public int arithmeticTriplets(int[] nums, int diff) {

            int count=0;

            for(int i=0;i<nums.length;i++){
                for(int j=i+1; j<nums.length;j++){

                    for(int k=j+1;k<nums.length;k++){
                        if(nums[k]-nums[j]==diff && nums[j]-nums[i]==diff){
                            count++;

                        }
                    }

                }            }

            return count;
        }*/

    // array method
    /*

    public int arithmeticTriplets(int @NotNull [] nums, int diff) {
        int  counter =0;
        for(int i=0; i<nums.length;i++){
            if(check(nums, nums[i]+diff )&& check(nums, nums[i]+2* diff)){
                counter++;
            }
        }


        return counter;
    }

    @Contract(pure = true)
    private boolean check(int @NotNull [] nums, int target) {
        for(int num : nums){
            if(num==target){
                 return true;
            }

        }
        return false;
    }*/

    public static void main(String[] args) {
        ArithmeticTriplets arithmeticTriplets= new ArithmeticTriplets();
        int arr[]= {4,5,6,7,8,9 };
        int ans=arithmeticTriplets.arithmeticTriplets(arr, 2);
        System.out.println(ans);
    }


/*
using hashmap
    public int arithmeticTriplets(int @NotNull [] nums, int diff) {
        HashMap<Integer, Integer> seen = new HashMap<>();
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            seen.put(nums[i], i);
        }
        for (int num : nums) {
            if (seen.containsKey(num + diff) && seen.containsKey(num + 2 * diff)) {
                counter++;
            }
        }
        return counter;
    }*/

    @Contract(pure = true)
    private boolean binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
    public int arithmeticTriplets(int[] nums, int diff) {
        int counter = 0;
        for (int num : nums) {
            if (binarySearch(nums, num + diff) && binarySearch(nums, num + 2 * diff)) {
                counter++;
            }
        }
        return counter;
    }

}

