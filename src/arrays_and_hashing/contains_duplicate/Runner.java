package arrays_and_hashing.contains_duplicate;

/**
 * Driver class for manually executing and verifying the different solution
 * approaches for the "Contains Duplicate" problem.
 * <p>
 * This class is intended for local testing and demonstration purposes. In a
 * production project, automated unit tests (e.g., JUnit) are the preferred way
 * to validate correctness.
 * </p>
 */
public class Runner {

	public static void main(String[] args) {

		// Sample input array containing a duplicate value (7)
		int[] input = { 2, 7, 11, 15, 7 };

		ContainsDuplicate solution = new ContainsDuplicate();

		// Approach 1: Brute Force
		boolean result = solution.approach1_bruteForce(input.clone());
		System.out.println("Approach 1 (Brute Force): " + result);

		// Approach 2: Sorting
		// Passing a cloned array since sorting modifies the original input.
		result = solution.approach2_sorting(input.clone());
		System.out.println("Approach 2 (Sorting): " + result);

		// Approach 3: HashSet
		result = solution.approach3_hashSet(input.clone());
		System.out.println("Approach 3 (HashSet): " + result);

		// Approach 4: Java Streams
		result = solution.approach4_streamDistinct(input.clone());
		System.out.println("Approach 4 (Stream.distinct()): " + result);
	}
}