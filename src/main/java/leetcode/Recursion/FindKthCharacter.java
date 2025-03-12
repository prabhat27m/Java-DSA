package src.main.java.leetcode.Recursion;

public class FindKthCharacter {
    public char solve(int ind, int k, String curr){
        if(curr.length()>=k){
            return curr.charAt(k-1);
        }

        StringBuilder newStr = new StringBuilder(curr);
        for(int i=0; i< curr.length(); i++){
            newStr.append((char) (curr.charAt(i) + 1));
        }

        return solve(ind+1, k, newStr.toString());

    }

    public char kthCharacter(int k) {
        return solve(0, k, "a");
    }
}
