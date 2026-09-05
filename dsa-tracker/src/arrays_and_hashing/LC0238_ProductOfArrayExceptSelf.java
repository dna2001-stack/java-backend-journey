package arrays_and_hashing;

import java.util.Arrays;

/**
 * LeetCode #238 - Product of Array Except Self
 * Difficulty: Medium
 * Pattern: Arrays & Hashing (Prefix & Suffix Products)
 * 
 * Time Complexity: O(N) - Two linear passes through the array.
 * Space Complexity: O(1) Auxiliary Space - Reuses output array with a single
 * rolling variable.
 */
public class LC0238_ProductOfArrayExceptSelf {

    /**
     * Calculates the product of all elements except self without using division.
     *
     * @param nums Input array of integers.
     * @return Output array where each index contains product of all elements except
     *         nums[i].
     */
    public int[] productExceptSelf(int[] nums) {
        // Guard clause: Handle null or empty input
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int length = nums.length;
        int[] answer = new int[length];

        // -------------------------------------------------------------
        // Pass 1: Build Prefix Products directly into answer array
        // answer[i] = product of all numbers to the left of index i
        // -------------------------------------------------------------
        answer[0] = 1; // Base case: No elements to the left of index 0
        for (int i = 1; i < length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // -------------------------------------------------------------
        // Pass 2: Multiply by Suffix Products in reverse order
        // suffixProduct tracks the running product of all numbers to the right
        // -------------------------------------------------------------
        int suffixProduct = 1; // Base case: No elements to the right of index (length - 1)
        for (int i = length - 1; i >= 0; i--) {
            answer[i] = answer[i] * suffixProduct;
            suffixProduct *= nums[i]; // Accumulate current number into suffix
        }

        return answer;
    }

    // Local Test Harness
    public static void main(String[] args) {
        LC0238_ProductOfArrayExceptSelf solver = new LC0238_ProductOfArrayExceptSelf();

        // Test Case 1: Standard input with all positive numbers
        int[] test1 = { 1, 2, 3, 4 };
        System.out.println("Test 1 Result: " + Arrays.toString(solver.productExceptSelf(test1)));
        // Expected: [24, 12, 8, 6]

        // Test Case 2: Array containing a zero
        int[] test2 = { -1, 1, 0, -3, 3 };
        System.out.println("Test 2 Result: " + Arrays.toString(solver.productExceptSelf(test2)));
        // Expected: [0, 0, 9, 0, 0]

        // Test Case 3: Array containing multiple zeroes
        int[] test3 = { 0, 4, 0 };
        System.out.println("Test 3 Result: " + Arrays.toString(solver.productExceptSelf(test3)));
        // Expected: [0, 0, 0]

        // Test Case 4: Minimal length (2 elements)
        int[] test4 = { 5, 10 };
        System.out.println("Test 4 Result: " + Arrays.toString(solver.productExceptSelf(test4)));
        // Expected: [10, 5]
    }
}