package arrays_and_hashing.valid_palindrome;

/**
 * LeetCode 125 - Valid Palindrome
 *
 * Problem Statement:
 * Given a string {@code s}, determine whether it is a palindrome,
 * considering only alphanumeric characters and ignoring cases.
 *
 * A palindrome reads the same forward and backward after removing
 * all non-alphanumeric characters and converting letters to the same case.
 *
 * Example:
 * Input:  "A man, a plan, a canal: Panama"
 * Output: true
 *
 * Input:  "race a car"
 * Output: false
 *
 * Constraints:
 * - 1 <= s.length <= 2 * 10^5
 * - s consists of printable ASCII characters.
 */
public class ValidPalindrome {

    /**
     * Approach 1: Brute Force
     *
     * Build a cleaned version of the string by:
     * - Keeping only alphanumeric characters.
     * - Converting all letters to lowercase.
     *
     * Then compare the cleaned string with its reverse.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param s Input string.
     * @return true if the cleaned string is a palindrome; otherwise false.
     */
    public boolean approach1_bruteForce(String s) {

        StringBuilder cleaned = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                cleaned.append(Character.toLowerCase(ch));
            }
        }

        String forward = cleaned.toString();
        String reversed = cleaned.reverse().toString();

        return forward.equals(reversed);
    }

    /**
     * Approach 2: Two Pointers (Optimal)
     *
     * Maintain two pointers from both ends of the string.
     * Skip non-alphanumeric characters and compare the remaining
     * characters after converting them to lowercase.
     *
     * The traversal stops immediately upon finding a mismatch.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param s Input string.
     * @return true if the string is a palindrome; otherwise false.
     */
    public boolean approach2_twoPointers(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            while (left < right && !isAlphaNumeric(s.charAt(left))) {
                left++;
            }

            while (left < right && !isAlphaNumeric(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left))
                    != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    /**
     * Determines whether a character is alphanumeric.
     *
     * This helper method avoids repeatedly calling
     * {@code Character.isLetterOrDigit()} and demonstrates
     * the underlying ASCII comparison.
     *
     * @param ch Character to evaluate.
     * @return true if the character is a letter or digit.
     */
    private boolean isAlphaNumeric(char ch) {

        return (ch >= 'A' && ch <= 'Z')
                || (ch >= 'a' && ch <= 'z')
                || (ch >= '0' && ch <= '9');
    }

}
