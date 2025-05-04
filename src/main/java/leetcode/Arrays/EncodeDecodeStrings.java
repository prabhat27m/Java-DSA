package src.main.java.leetcode.Arrays;

import java.util.*;

public class EncodeDecodeStrings {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str.length()).append('#').append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            int j = i;

            while (s.charAt(j) != '#') {
                j++;
            }

            int len = Integer.parseInt(s.substring(i, j));
            res.add(s.substring(j + 1, j + 1 + len));
            i = j + 1 + len;
        }

        return res;
    }

    public static void main(String[] args) {
        EncodeDecodeStrings sol = new EncodeDecodeStrings();

        List<String> strs1 = Arrays.asList("lint", "code", "love", "you");
        String encoded1 = sol.encode(strs1);
        List<String> decoded1 = sol.decode(encoded1);
        System.out.println("Encoded: " + encoded1);
        System.out.println("Decoded: " + decoded1);

        List<String> strs2 = Arrays.asList("we", "are", "the", "champions");
        String encoded2 = sol.encode(strs2);
        List<String> decoded2 = sol.decode(encoded2);
        System.out.println("Encoded: " + encoded2);
        System.out.println("Decoded: " + decoded2);

        List<String> strs3 = Arrays.asList("");
        String encoded3 = sol.encode(strs3);
        List<String> decoded3 = sol.decode(encoded3);
        System.out.println("Encoded: " + encoded3);
        System.out.println("Decoded: " + decoded3);
    }
}

// length of the string + # + actual string