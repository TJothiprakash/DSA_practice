package Curious_Freaks.stringHard;

import java.util.*;

class Solution07 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String str : strs) {
            // Convert the string to a character array, sort it, and convert it back to a string
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            // Use the sorted string as a key in the hashmap
            anagramGroups.putIfAbsent(sortedStr, new ArrayList<>());
            anagramGroups.get(sortedStr).add(str);
        }

        return new ArrayList<>(anagramGroups.values());
    }

}

public class GroupAnagrams {
}
