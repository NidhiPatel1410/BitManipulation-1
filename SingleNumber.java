// Two nested loops will be bruteforce - Outer loop we start, then we again
// iterate the entire array to search
// this element in outer loop.

// We can use hashset also but it will be O(n)

// Optimize:
// In this approach, we are using the property of xor operation that the xor of
// the number with itself is 0.
// So all the elements appearing twice will cancel each other out and we will
// only be left with our answer.

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int singleNumber(int[] nums) {
        // Base case
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // Take the variable
        int xor = 0;
        // Loop for nums
        for (int num : nums) {
            // Take xor of all, because xor of same number with itself is 0, so since we
            // have numbers appearing twice, they will cancel each other out and the single
            // number will be left
            xor = xor ^ num;
        }
        return xor;
    }
}