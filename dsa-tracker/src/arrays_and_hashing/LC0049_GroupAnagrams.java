package arrays_and_hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode #49 - Group Anagrams
 * Difficulty: Medium
 * Pattern: Arrays & Hashing (Canonical Hash Key)
 * 
 * Time Complexity: O(N * K log K) where N is number of strings, K is max string
 * length.
 * Space Complexity: O(N * K) to store grouped anagrams in HashMap.
 */
public class LC0049_GroupAnagrams {

    /**
     * Groups an array of strings into anagram clusters.
     *
     * @param strs Array of input strings.
     * @return List of grouped anagram lists.
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // Guard Clause: Handle null or empty input array
        if (strs == null || strs.length == 0) {
            return Collections.emptyList();
        }

        // Map to store: Canonical Sorted Key -> List of original anagram words
        Map<String, List<String>> anagramGroupsMap = new HashMap<>();

        for (String currentWord : strs) {
            // Guard against null elements inside the array
            if (currentWord == null) {
                continue;
            }

            // Step 1: Convert word to character array and sort it
            char[] characterArray = currentWord.toCharArray();
            Arrays.sort(characterArray);

            // Step 2: Create canonical key from the sorted characters
            String canonicalKey = new String(characterArray);

            // Step 3: Insert into map using Java 8+ computeIfAbsent
            anagramGroupsMap
                    .computeIfAbsent(canonicalKey, key -> new ArrayList<>())
                    .add(currentWord);
        }

        // Step 4: Return all grouped lists as a new ArrayList
        return new ArrayList<>(anagramGroupsMap.values());
    }

    // Local Test Harness
    public static void main(String[] args) {
        LC0049_GroupAnagrams solver = new LC0049_GroupAnagrams();

        // Test Case 1: Standard input with multiple anagram groups
        String[] test1 = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println("Test 1 Result: " + solver.groupAnagrams(test1));
        // Expected: [["eat", "tea", "ate"], ["tan", "nat"], ["bat"]] (order of groups
        // may vary)

        // Test Case 2: Single empty string
        String[] test2 = { "" };
        System.out.println("Test 2 Result: " + solver.groupAnagrams(test2));
        // Expected: [[""]]

        // Test Case 3: Single character
        String[] test3 = { "a" };
        System.out.println("Test 3 Result: " + solver.groupAnagrams(test3));
        // Expected: [["a"]]

        // Test Case 4: No anagrams present
        String[] test4 = { "abc", "def", "ghi" };
        System.out.println("Test 4 Result: " + solver.groupAnagrams(test4));
        // Expected: [["abc"], ["def"], ["ghi"]]
    }
}