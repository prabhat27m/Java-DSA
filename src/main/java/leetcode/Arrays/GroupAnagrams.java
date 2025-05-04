package src.main.java.leetcode.Arrays;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams sol = new GroupAnagrams();

        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res1 = sol.groupAnagrams(strs1);
        System.out.println("Grouped Anagrams: " + res1);

        String[] strs2 = {""};
        List<List<String>> res2 = sol.groupAnagrams(strs2);
        System.out.println("Grouped Anagrams: " + res2);

        String[] strs3 = {"a"};
        List<List<String>> res3 = sol.groupAnagrams(strs3);
        System.out.println("Grouped Anagrams: " + res3);
    }
}
