// In this problem using the property of xor and 2s complement. First doing the xor of all, so all the twice appearing elements will
// cancel each other out. We will be left with the xor of two single elements that we have to find. Now, if take the 2s complement of
// this xor (say stored in temp), then there is this property that when we do the bitwise AND of this 2s complement with one of the 
// number from answer it will be non-zero value and the 2s complement with other will be zero value. So we run a loop again on nums,
// and if the bitwise AND with temp is zero, we ignore that, but if it is non-zero we do the xor of all such numbers. 
// So at last this xor2 will have one of our number, and if we do the xor of one of the ans with the first xor that we did, it will
// give other answer 

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int[] singleNumber(int[] nums) {
        // Base case
        if (nums == null || nums.length < 2) {
            return new int[] {};
        }
        // Declare xor
        int xor = 0;
        // Do the first loop and find xor of all
        for (int num : nums) {
            xor = xor ^ num;
        }
        // Take 2s comp of it
        int temp = xor & (-xor);
        // Declare xor2 for second xor
        int xor2 = 0;
        // Loop
        for (int num : nums) {
            // If the bitwise AND result is non-zero
            if ((temp & num) != 0) {
                // Do the xor
                xor2 = xor2 ^ num;
            }
        }
        // Return two numbers
        return new int[] { xor2, xor ^ xor2 };
    }
}