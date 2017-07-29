package i.am.jameshughkim.interviewsPrep._1_expedia.algorithms.array.dp;

public class LIS_Variations {
    /*
    Given an array, find the longest # of increasing subsequence

    | i  | 1 | 2 | 3 | 4 | 5 | 6 |
    |----|---|---|---|---|---|---|
    |A[i]|10 |20 |10 |30 |20 |50 |
    |D[i]|1  |2  |1  |3  |2  |3  |

    D[1] = 1

    */
    int longestIncreasingSubsequence(int[] a) {
        int[] dp = new int[a.length];
        int max = Integer.MIN_VALUE;

        for (int i=0;i<a.length;i++) {
            dp[i] = 1; // 자신을 포함한 최소 수열의 길이는 1임

            // i 이전까지의 순열을 재검색해서
            for (int j=0;j<i; j++) {
                if (a[j] <a[i] && // 이전 수가 현재수 보다 작은 경우
                        dp[i] < dp[j] + 1) // ...
                    dp[i] = dp[j] + 1;
            }
        }

        for (int i=1;i<dp.length;i++) max = Math.max(dp[i], max);

        return max;
    }

    //
    int maxSumIncreasingSubsequence(int[] a) {
        int[] dp = new int[a.length];
        int max = Integer.MIN_VALUE;
        for (int i=0; i<a.length; i++) {
            dp[i] = a[i];
            for (int j=0; j<i; j++) {
                if (a[j] < a[i] && dp[i] < dp[j] + a[i]) {
                    dp[i] = dp[j] + a[i];
                }
            }
        }
        for (int i=1;i<dp.length;i++) max = Math.max(dp[i], max);

        return max;
    }




}
