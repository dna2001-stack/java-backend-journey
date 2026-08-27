package arrays_and_hashing;

import java.util.HashSet;
import java.util.Set;

public class LC217_ContainsDuplicate {

    // --- LeetCode Solution Method ---
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    // --- Local Test Runner ---
    public static void main(String[] args) {
        LC217_ContainsDuplicate solver = new LC217_ContainsDuplicate();

        int[] test1 = {1, 2, 3, 1};
        System.out.println("Test 1 Result: " + solver.containsDuplicate(test1)); // Expected: true

        int[] test2 = {1, 2, 3, 4};
        System.out.println("Test 2 Result: " + solver.containsDuplicate(test2)); // Expected: false

        int[] test3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println("Test 3 Result: " + solver.containsDuplicate(test3)); // Expected: true
    }
}