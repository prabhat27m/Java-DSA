package src.main.java.leetcode.TwoPointer;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null) return false;

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Skip non-alphanumeric characters
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters ignoring case
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome sol = new ValidPalindrome();

        String test1 = "A man, a plan, a canal: Panama";
        System.out.println("Is Palindrome: " + sol.isPalindrome(test1)); // true

        String test2 = "race a car";
        System.out.println("Is Palindrome: " + sol.isPalindrome(test2)); // false

        String test3 = " ";
        System.out.println("Is Palindrome: " + sol.isPalindrome(test3)); // true
    }
}
