// In this approach, we are trying to use property of bitwise operators. We are taking the divisor and lshifting it by 1. Then doing this 
// till the value of shifting becomes greater than the dividend. Then we count the number of times we shifted before it became greater
// Then left shifting 1 that many times to get our result. Now if the difference of dividend and that last value we got before the 
// left shift value became greater, if it is greater than divisor than we do all same steps for the subproblem difference/divisor. And
// add that to existing result.

// Time Complexity : O(logn) because we are doing the moving in powers of divisor
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int divide(int dividend, int divisor) {
        // Base - Divide by 0, return max
        if (dividend != 0 && divisor == 0)
            return Integer.MAX_VALUE;
        // Negative infinity divide by -1, return positive infinity
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        // Since we will do left shifts, there is a possibility of going out of range of
        // integer, so convert to long
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        // Take result variable
        int result = 0;
        // Incase we get the difference of ldividend and divisor left shifted greater
        // than the divisor, we will do this process
        while (ldividend >= ldivisor) {
            // Take a shifts variable to count the number of times we left shifted the
            // divisor before the value of shifting became greater than ldividend
            int shifts = 0;
            // So loop till ldividend is greater
            while (ldividend >= ldivisor << shifts) {
                // Increase number of shifts
                shifts++;
            }
            // After it becomes greater, go back to one less since that is total number of
            // times we shifted before value became greater
            shifts--;
            // Now left shift 1 that many times and add in result
            result = result + (1 << shifts);
            // Store the difference of the ( left shifted shifts times ans ) and ldividend
            // in ldividend, so that if the difference is greater than our divisor, we do
            // the steps again
            ldividend = ldividend - (ldivisor << shifts);
        }
        // If either one of it is negative, return negative result
        if (dividend < 0 && divisor > 0)
            return -result;
        if (dividend > 0 && divisor < 0)
            return -result;
        // Else positive result
        return result;
    }
}