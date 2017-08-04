package i.am.jameshughkim.interviewsPrep.companies._4_concur;

import org.junit.jupiter.api.Test;

public class MultiplicationTable {
    int[][] generateMultiplicationTable(int n) {
        int[][] tbl = new int[n][n];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                tbl[row][col] = row * col;
            }
        }

        return tbl;
    }

    @Test
    void printMultiplicationTable() {
        int n = 5;
        int[][] tbl = generateMultiplicationTable(n);

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(tbl[row][col] + " ");
            }
            System.out.println();
        }
    }
}
