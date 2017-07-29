package i.am.jameshughkim.interviewsPrep.code_rust.array.dp;

public class LongestIncreasingSubstring {
    public int getLongestIncreasingSubstring(int[] a) {
        int n = a.length;
        int[] lis = new int[n];

        for (int i=0;i<n;i++) {
            lis[i] = 1;
            for (int j=0;j<i;j++) {
                if (a[j] < a[i] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i=0;i<n;i++) {
            if (max < lis[i]) max = lis[i];
        }
        return max;
    }
}
