package cheat;

import i.am.jameshughkim.interviewsPrep.testUtils.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Given a two dimensional array, if any element in it is zero make its whole row and column zero
 */
public class MakeColumnsRowsZeroes {
    void makeColRowsZeroes(int[][] a) {
        if (a.length <= 1) return;
        Set<Integer> rSet = new HashSet<>();
        Set<Integer> cSet = new HashSet<>();

        for (int r=0;r<a.length; r++) {
            for (int c=0;c<a[0].length; c++) {
                if (a[r][c] == 0) {
                    rSet.add(r);
                    cSet.add(c);
                }
            }
        }

        for (int r: rSet) for (int c=0;c<a.length;c++) a[r][c] = 0;
        for (int c: cSet) for (int r=0;r<a.length;r++) a[r][c] = 0;

    }

    /***************
     * TEST
     ****************/

    static Stream<Pair<int[][], int[][]>> testCases2() {
        return Stream.of(
                Pair.of(new int[][]{
                                {1}
                        },
                        new int[][]{
                                {1}
                        }),
                Pair.of(new int[][]{
                                {0}
                        },
                        new int[][]{
                                {0}
                        }),
                Pair.of(new int[][]{
                                {5,4,3,9},
                                {2,0,7,6},
                                {1,3,4,0},
                                {9,8,3,4},
                        },
                        new int[][]{
                                {5,0,3,0},
                                {0,0,0,0},
                                {0,0,0,0},
                                {9,0,3,0},
                })
        );
    }

    @ParameterizedTest
    @MethodSource(names = "testCases2")
    void test(Pair<int[][], int[][]> testCase) {
        int[][] actual = testCase.getFirst();
        int[][] expected = testCase.getSecond();

        makeColRowsZeroes(actual);

        Assertions.assertArrayEquals(expected, actual);
    }

}
