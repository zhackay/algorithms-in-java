package cheat.dp;

public class Fibonacci {
    private int[] dp;

    // 두가지 예외 F(0) = 0, F(1) = 1
    // Top Down
    int fib(int n) {
        if (n <= 1) return n;

        dp[n] = fib(n-1) + fib(n-2);
        return dp[n];
    }

    int fibBu(int n) {
        int[] dp = new int[n];

        dp[0] = 0;
        dp[1] = 1;

        for (int i=2;i<=n;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    /**
     * WRAPPER
     */
1
    public int getFib(int n) {
        dp = new int[n];

        return fib(n);
    }

}
