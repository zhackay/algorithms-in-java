package i.am.jameshughkim.interviewsPrep.code_plus.dp;

public class Fibonacci {
    // 두가지 예외 F(0) = 0, F(1) = 1
    //
    int fib(int n) {
        if (n <= 1) return n;

        int[] dp = new int[n];
        dp[n] = fib(n-1) + fib(n-2);
        return dp[n];
    }
}
