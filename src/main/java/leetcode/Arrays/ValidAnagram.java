package src.main.java.leetcode.Arrays;

public class ValidAnagram {
    public boolean validAnagram(String s, String t){
        int [] hash = new int[26];

        if(s.length() != t.length()) return false;

        for(int i=0; i< s.length(); i++){
            hash[s.charAt(i)-'a']++;
            hash[t.charAt(i)-'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if(hash[i]>0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidAnagram sol = new ValidAnagram();
    // Test Case 1 :
        String s1 = "anagram";
        String t1 = "nagaram";
        System.out.println("Valid Anagram :" + sol.validAnagram(s1, t1));
    // Test Case 2 :1
        String s2 ="rat";
        String t2= "car";

        System.out.println("Valid Anagram :" + sol.validAnagram(s2, t2));


    }
}
