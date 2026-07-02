package arrays_and_hashing.valid_anagram;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 242 - Valid Anagram
 *
 * Problem Statement:
 * Given two strings {@code s} and {@code t}, return {@code true} if
 * {@code t} is an anagram of {@code s}; otherwise, return {@code false}.
 *
 * An anagram is a word or phrase formed by rearranging the letters of
 * another word, using all the original characters exactly once.
 *
 * Example:
 * Input:  s = "anagram", t = "nagaram"
 * Output: true
 *
 * Input:  s = "rat", t = "car"
 * Output: false
 *
 * This class demonstrates multiple approaches to solving the problem,
 * highlighting the trade-offs between simplicity, efficiency, and
 * applicability to different character sets.
 *
 * Preferred Interview Solution:
 * Approach 2 (Frequency Array) for lowercase English letters.
 * Approach 3 (HashMap) for general Unicode characters.
 */
public class ValidAnagram {

    /**
     * Approach 1: Sorting
     *
     * Converts both strings into character arrays, sorts them,
     * and compares the sorted arrays.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     *
     * @param s First input string.
     * @param t Second input string.
     * @return true if the strings are anagrams; otherwise false.
     */
    public boolean approach1_sorting(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        char[] sSort = s.toCharArray();
        char[] tSort = t.toCharArray();

        Arrays.sort(sSort);
        Arrays.sort(tSort);

        return Arrays.equals(sSort, tSort);
    }

    /**
     * Approach 2: Frequency Array
     *
     * Uses a fixed-size integer array of length 26 to count character
     * frequencies. Increment for characters in the first string and
     * decrement for characters in the second string.
     *
     * Assumption:
     * Both strings contain only lowercase English letters ('a' to 'z').
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param s First input string.
     * @param t Second input string.
     * @return true if the strings are anagrams; otherwise false.
     */
    public boolean approach2_frequencyArray(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] frequency = new int[26];

        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
            frequency[t.charAt(i) - 'a']--;
        }

        for (int count : frequency) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Approach 3: HashMap
     *
     * Maintains character frequencies using a HashMap.
     * Suitable for any character set, including Unicode.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(k)
     * where k is the number of distinct characters.
     *
     * @param s First input string.
     * @param t Second input string.
     * @return true if the strings are anagrams; otherwise false.
     */
    public boolean approach3_hashMap(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char ch : s.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        for (char ch : t.toCharArray()) {

            if (!frequencyMap.containsKey(ch)) {
                return false;
            }

            frequencyMap.put(ch, frequencyMap.get(ch) - 1);

            if (frequencyMap.get(ch) == 0) {
                frequencyMap.remove(ch);
            }
        }

        return frequencyMap.isEmpty();
    }

}