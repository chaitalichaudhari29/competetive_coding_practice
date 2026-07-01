package arrays_and_hashing.contains_duplicate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 217 - Contains Duplicate
 *
 * Problem Statement: Given an integer array, determine whether any value
 * appears at least twice. Return {@code true} if any element appears more than
 * once; otherwise, return {@code false}.
 *
 * Example: Input: [1, 2, 3, 1] Output: true
 *
 * Input: [1, 2, 3, 4] Output: false
 *
 * Constraints: - 1 <= nums.length <= 10^5 - -10^9 <= nums[i] <= 10^9
 *
 */
public class ContainsDuplicate {

	/**
	 * Approach 1: Brute Force
	 *
	 * Compares every element with every other element.
	 *
	 * Time Complexity: O(n²) Space Complexity: O(1)
	 *
	 * @param nums Input integer array.
	 * @return true if a duplicate exists; otherwise false.
	 */
	public boolean approach1_bruteForce(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] == nums[j]) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Approach 2: Sorting
	 *
	 * Sorts the array first. Any duplicate values will become adjacent.
	 *
	 * Time Complexity: O(n log n) Space Complexity: - O(log n) for Java's
	 * Dual-Pivot Quicksort (primitive arrays)
	 *
	 * 
	 * @param nums Input integer array.
	 * @return true if a duplicate exists; otherwise false.
	 */
	public boolean approach2_sorting(int[] nums) {
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1]) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Approach 3: HashSet
	 *
	 * Traverse the array while storing previously seen elements in a HashSet.
	 *
	 * If the current element already exists in the set, a duplicate has been found.
	 *
	 * Time Complexity: O(n) Space Complexity: O(n)
	 *
	 * @param nums Input integer array.
	 * @return true if a duplicate exists; otherwise false.
	 */
	public boolean approach3_hashSet(int[] nums) {

		Set<Integer> visited = new HashSet<>();

		for (int num : nums) {
			if (visited.contains(num)) {
				return true;
			}
			visited.add(num);
		}

		return false;
	}

	/**
	 * Approach 4: Java Streams
	 *
	 * Uses Stream.distinct() to remove duplicate elements and compares the
	 * resulting count with the original array length.
	 *
	 * Time Complexity: O(n) Space Complexity: O(n)
	 *
	 * @param nums Input integer array.
	 * @return true if a duplicate exists; otherwise false.
	 */
	public boolean approach4_streamDistinct(int[] nums) {
		return Arrays.stream(nums).distinct().count() < nums.length;
	}
}