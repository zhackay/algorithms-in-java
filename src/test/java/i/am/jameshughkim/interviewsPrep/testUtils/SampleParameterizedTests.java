package i.am.jameshughkim.interviewsPrep.testUtils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SampleParameterizedTests {
    /***************
     * Pair
     ****************/

    static Stream<Pair<int[], Integer>> testCases2() {
        return Stream.of(
                Pair.of(new int[]{3,3,3,3},3),
                Pair.of(new int[]{1, 2, 3, 4, 4, 4, 5},4),
                Pair.of(new int[]{3},3),
                Pair.of(new int[]{1, 2, 3, 4, 4, 4, 5},6));
    }

    @ParameterizedTest
    @MethodSource(names = "testCases2")
    void test(Pair<int[], Integer> testCase) {
        int[] a = testCase.getFirst();
        int expected = testCase.getSecond();

        Assertions.assertEquals(expected, solve());
    }

    /***************
    * Triplet
    ****************/

    static int solve() {
        return -1;
    }

    static Stream<Triplet<int[], Integer, int[]>> testCases3() {
        return Stream.of(
                Triplet.of(new int[]{3,3,3,3},3, new int[] {0, 3}),
                Triplet.of(new int[]{1, 2, 3, 4, 4, 4, 5},4, new int[] {3, 5}),
                Triplet.of(new int[]{3},3, new int[] {0, 0}),
                Triplet.of(new int[]{1, 2, 3, 4, 4, 4, 5},6, new int[] {-1, -1}));
    }

    @ParameterizedTest
    @MethodSource(names = "testCases3")
    void test(Triplet<int[], Integer, int[]> testCase) {
        int[] a = testCase.getFirst();
        int k = testCase.getSecond();
        int[] expected = testCase.getThird();

        Assertions.assertEquals(expected, solve());
    }

}
