package arrays_and_hashing;

public class LC242_ValidAnagram {

    // --- LeetCode Solution Method ---
    public boolean isAnagram(String s, String t) {

        // Step 1: If lengths don't match, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Step 2: Create a frequency array for all 26 lowercase English letters ('a' to
        // 'z')
        int[] letterCounts = new int[26];

        // Step 3: Count letters in 's' (+1) and 't' (-1)
        for (int i = 0; i < s.length(); i++) {
            // 'a' - 'a' = index 0, 'b' - 'a' = index 1, ..., 'z' - 'a' = index 25
            letterCounts[s.charAt(i) - 'a']++;
            letterCounts[t.charAt(i) - 'a']--;
        }

        // Step 4: Verify all letter counts balanced back to 0
        for (int count : letterCounts) {
            if (count != 0) {
                return false; // Found a mismatch
            }
        }

        return true; // All counts are 0, perfect anagram!
    }

    // --- Local Test Runner ---
    public static void main(String[] args) {
        LC242_ValidAnagram solver = new LC242_ValidAnagram();

        // Test 1: Should be true
        String s1 = "anagram";
        String t1 = "nagaram";
        System.out.println("Test 1 (\"anagram\", \"nagaram\"): " + solver.isAnagram(s1, t1)); // Expected: true

        // Test 2: Should be false
        String s2 = "rat";
        String t2 = "car";
        System.out.println("Test 2 (\"rat\", \"car\"): " + solver.isAnagram(s2, t2)); // Expected: false

        // Test 3: Different lengths
        String s3 = "a";
        String t3 = "ab";
        System.out.println("Test 3 (\"a\", \"ab\"): " + solver.isAnagram(s3, t3)); // Expected: false
    }
}