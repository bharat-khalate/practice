package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Problem Given an array of strings, return all groups of strings that are
 *          anagrams. The strings in each group must be arranged in the order of
 *          their appearance in the original array. Refer to the sample case for
 *          clarification.
 * 
 * @Example Input: arr[] = ["act", "god", "cat", "dog", "tac"]
 *          Output: [["act", "cat", "tac"], ["god", "dog"]]
 *          Explanation: There are 2 groups of anagrams "god", "dog" make group
 *          1. "act", "cat", "tac" make group 2.
 * 
 *          Input: arr[] = ["no", "on", "is"]
 *          Output: [["is"], ["no", "on"]]
 *          Explanation: There are 2 groups of anagrams "is" makes group 1.
 *          "no", "on" make group 2.
 * 
 *          Input: arr[] = ["listen", "silent", "enlist", "abc", "cab", "bac",
 *          "rat", "tar", "art"]
 *          Output: [["abc", "cab", "bac"], ["listen", "silent", "enlist"],
 *          ["rat", "tar", "art"]]
 *          Explanation:
 *          Group 1: "abc", "bac", and "cab" are anagrams.
 *          Group 2: "listen", "silent", and "enlist" are anagrams.
 *          Group 3: "rat", "tar", and "art" are anagrams.
 */
public class GroupByAnagram {
    public static void main(String[] args) {
        System.out.println(anagrams(new String[] { "act", "god", "cat", "dog", "tac" }));
    }

    public static ArrayList<ArrayList<String>> anagrams(String[] arr) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String str : arr) {
            String key = getHash(str);
            if (!map.containsKey(key)) {
                map.put(key, res.size());
                res.add(new ArrayList<>());
            }
            res.get(map.get(key)).add(str);
        }
        return res;
    }

    public static String getHash(String str) {
        int freq[] = new int[26];
        StringBuilder hash = new StringBuilder();
        for (char c : str.toCharArray())
            freq[c - 'a']++;
        for (int count : freq) {
            hash.append(count);
            hash.append(".");
        }
        return hash.toString();
    }
}
