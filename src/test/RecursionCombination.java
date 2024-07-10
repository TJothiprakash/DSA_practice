package test;

import java.util.*;
class RecursionCombination
{

    private void findCombinations(int ind, int[] arr, int target, List < List < Integer >> ans, List < Integer > ds) {
        if (ind == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList < > (ds));
            }
            return;
        }

        if (arr[ind] <= target) {
            ds.add(arr[ind]);
            findCombinations(ind, arr, target - arr[ind], ans, ds);
            ds.remove(ds.size() - 1);
        }
        findCombinations(ind + 1, arr, target, ans, ds);
    }
    public List < List < Integer >> combinationSum(int[] candidates, int target) {
        List < List < Integer >> ans = new ArrayList < > ();
        findCombinations(0, candidates, target, ans, new ArrayList < > ());
        return ans;
    }
}
 class Main21 {
    public static void main(String[] args) {
      //  DriverManager.getConnection();
        int arr[] = {2,3,6,7};
        int target = 7;
        RecursionCombination sol = new RecursionCombination();
        List < List < Integer >> ls = sol.combinationSum(arr, target);
        System.out.println("Combinations are: ");
        for (int i = 0; i < ls.size(); i++) {
            for (int j = 0; j < ls.get(i).size(); j++) {
                System.out.print(ls.get(i).get(j) + " ");
            }
            System.out.println();
        }

        /*var url = "jdbc:derby:bunnies"; var sql = "INSERT INTO bunny(name, color) VALUES (?, ?)";
        try (var conn = DriverManager.getConnection(url);
             var stmt = conn.createStatement()) {

                stmt.setString(1, "Hoppy");
            stmt.setString(2, "Brown");
                stmt.executeUpdate(sql); } catch (SQLException e) {
            throw new RuntimeException(e);*/
        }
    }
