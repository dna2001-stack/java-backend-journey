package arrays_and_hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode #347 - Top K Frequent Elements
 * Difficulty: Medium
 * Pattern: Arrays & Hashing (Bucket Sort)
 * 
 * Time Complexity: O(N) where N is the number of elements in nums.
 * Space Complexity: O(N) to store frequencies in HashMap and buckets.
 */
public class LC0347_TopKFrequentElements {

    /**
     * Finds the k most frequent elements in the array using Bucket Sort.
     *
     * @param nums Input array of integers.
     * @param k    The number of top frequent elements to return.
     * @return Array of k most frequent numbers.
     */
    public int[] topKFrequent(int[] nums, int k) {
        // Guard Clause: Check for empty input
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        // Step 1: Count frequency of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Bucket array where index = frequency count
        @SuppressWarnings("unchecked")
        List<Integer>[] buckets = new List[nums.length + 1];

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int number = entry.getKey();
            int frequency = entry.getValue();

            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(number);
        }

        // Step 3: Collect top k elements starting from highest frequency bucket
        int[] result = new int[k];
        int resultIndex = 0;

        for (int freq = buckets.length - 1; freq >= 0 && resultIndex < k; freq--) {
            if (buckets[freq] != null) {
                for (int number : buckets[freq]) {
                    result[resultIndex++] = number;
                    if (resultIndex == k) {
                        break;
                    }
                }
            }
        }

        return result;
    }

    // Local Test Harness
    public static void main(String[] args) {
        LC0347_TopKFrequentElements solver = new LC0347_TopKFrequentElements();

        // Test Case 1: Standard input
        int[] nums1 = { 1, 1, 1, 2, 2, 3 };
        int k1 = 2;
        System.out.println("Test 1 Result: " + Arrays.toString(solver.topKFrequent(nums1, k1)));
        // Expected: [1, 2]

        // Test Case 2: Single element
        int[] nums2 = { 4 };
        int k2 = 1;
        System.out.println("Test 2 Result: " + Arrays.toString(solver.topKFrequent(nums2, k2)));
        // Expected: [4]

        // Test Case 3: Negative numbers
        int[] nums3 = { -1, -1, 2, 2, 2, 3 };
        int k3 = 2;
        System.out.println("Test 3 Result: " + Arrays.toString(solver.topKFrequent(nums3, k3)));
        // Expected: [2, -1]
    }
}