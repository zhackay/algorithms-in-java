package cheat.dp;

/** Kadane's algorithms
 *
 * Kadane found: If we know the max sum at the position i, then, what is the max sum at position i+1?
 * Solution: Either
 *      maxSum(i) + A[i], or
 *      A[i]
 *
 * Simple Explanation: https://en.wikipedia.org/wiki/Maximum_subarray_problem#Kadane.27s_algorithm
 * Detailed Explanation: http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 */
public class MaxSumContiguousSubArray {

    int maxSubArraySum(int a[])
    {
        int max_so_far = 0, max_ending_here = 0;
        for (int i = 0; i < a.length; i++)
        {
            max_ending_here = max_ending_here + a[i];
            if (max_ending_here < 0)
                max_ending_here = 0;

       /* Do not compare for all elements. Compare only
          when  max_ending_here > 0 */
            else if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
        }
        return max_so_far;
    }

    // This handles when all the array elements are negative
    // dp?? maybe in a way that it saves curr_max and max_so_far?
    public int maxSubArraySumDp(int[] a) {
        if (a.length == 0) return 0;

        int max_so_far = a[0];
        int curr_max = a[0];

        for (int i = 1; i < a.length; i++)
        {
            curr_max = Math.max(a[i], curr_max+a[i]);
            max_so_far = Math.max(max_so_far, curr_max);
        }
        return max_so_far;
    }

    // To print the subarray with the maximum sum, we maintain indices whenever we get the maximum sum.
    public void printIndicesOfMaxSumSubArray(int[] a) {
        int max_so_far = Integer.MAX_VALUE;
        int max_ending_here = 0;
        int start = 0, end = 0, s = 0;

        for (int i=0; i< a.length; i++ )
        {
            max_ending_here += a[i];

            if (max_so_far < max_ending_here)
            {
                max_so_far = max_ending_here;
                start = s;
                end = i;
            }

            if (max_ending_here < 0)
            {
                max_ending_here = 0;
                s = i+1;
            }
        }

        System.out.println("Maximum contiguous sum is " + max_so_far);
        System.out.println("Starting index " + start);
        System.out.println("Ending index " + end);
    }
}
