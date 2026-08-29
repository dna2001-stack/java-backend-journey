package arrays_and_hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode #1: Two Sum
 * Difficulty: Easy
 * Pattern: One-Pass HashMap (Complement Lookup)
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
public class LC001_TwoSum {

    // --- LeetCode Solution Method ---
    public int[] twoSum(int[] nums, int target) {
        // Map to store: Number -> Index
        Map<Integer, Integer> seenNumbers = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if the required complement was already seen
            if (seenNumbers.containsKey(complement)) {
                return new int[] { seenNumbers.get(complement), i };
            }

            // Otherwise, remember this number and its index
            seenNumbers.put(nums[i], i);
        }

        // Return empty array if no pair found
        return new int[] {};
    }

    // --- Local Test Runner ---
    public static void main(String[] args) {
        LC001_TwoSum solver = new LC001_TwoSum();

        // Test Case 1
        int[] nums1 = { 2, 7, 11, 15 };
        int target1 = 9;
        System.out.println("Test 1 Result: " + Arrays.toString(solver.twoSum(nums1, target1))); // Expected: [0, 1]

        // Test Case 2
        int[] nums2 = { 3, 2, 4 };
        int target2 = 6;
        System.out.println("Test 2 Result: " + Arrays.toString(solver.twoSum(nums2, target2))); // Expected: [1, 2]

        // Test Case 3
        int[] nums3 = { 3, 3 };
        int target3 = 6;
        System.out.println("Test 3 Result: " + Arrays.toString(solver.twoSum(nums3, target3))); // Expected: [0, 1]
    }
}