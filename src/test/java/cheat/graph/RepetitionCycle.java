package cheat.graph;

import java.util.HashMap;

public class RepetitionCycle {
    private HashMap<Integer, Integer> check = new HashMap<>(); // val, count
    private int[] a;

    public RepetitionCycle(int a[]) {
        this.a = a;
    }
    /**
     * https://www.acmicpc.net/problem/2331
     */
    public int getLengthOfNonRepeatingPermutation(int p) {
        check.clear();
        return repetitionDfsIterative(p);
    }

    public int repetitionDfsIterative(int p) {
        int pos = 0;
        int x = calculate(a[pos], p);

        while (check.get(x) == null) {
            check.put(x, pos);
            x = calculate(a[++pos], p);
        }
        return pos;
    }

    // VERY IMPORTANT !!
    private int calculate(int x, int p) {
        int result = 0;

        while (x > 0) {
            int r = x % 10;
            x = x / 10;
            result += Math.pow(r, p);
        }
        return result;
    }
}
