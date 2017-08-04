package cheat;

import i.am.jameshughkim.interviewsPrep.testUtils.Triplet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * <h1>Two Sum</h1>
 * Given an integer array and a value,
 * determine if there are any two integers in the array which sum equal to the given value
 */
public class TwoSum {

    boolean twoSum(int[] a, int sum) {
        HashSet<Integer>  set = new HashSet<>();
        for (int i=0; i<a.length; i++) {
            if (set.contains(sum - a[i]))
                return true;
            set.add(a[i]);
        }
        return false;
    }

    /*************
     * My Solution - Which is lame
     *************/

    boolean twoSum3(int[] a, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            int key = a[i];
            if (!map.containsKey(key))
                map.put(key, 1);
            else {
                int val = map.get(key);
                map.put(key, val + 1);
            }
        }

        for (int i = 0; i < a.length; i++) {
            int key = a[i];
            int target = sum - key;

            map.put(key, (map.get(key) - 1));

            if (map.containsKey(target)) {
                if (map.get(target) >= 0) return true;
            }
        }
        return false;
    }

    /*************
     * Solution
     *************/

    // O(n) / O(n)

    boolean twoSum2(int[] a, int sum) {
        Set<Integer> found = new HashSet<>();
        for (int i : a) {
            int target = sum - i;
            if (found.contains(target)) // this works, because it traverses either of the pair first
                return true;
            found.add(i);
        }
        return false;
    }

    /*************
     * TESTS
     *************/

    static Stream<Triplet<int[], Integer, Boolean>> testCases() {
        return Stream.of(
                Triplet.of(new int[]{4,2,6,12,4,7,3}, 9, true),
                Triplet.of(new int[]{1,2,3,4,5}, 6, true),
                Triplet.of(new int[]{1,2,3,4,5}, 50, false)
        );
    }

    @ParameterizedTest
    @MethodSource(names = "testCases")
    void test(Triplet<int[], Integer, Boolean> testCase) {
        int[] input = testCase.getFirst();
        int sum = testCase.getSecond();
        boolean expected = testCase.getThird();

        Assertions.assertEquals(expected, twoSum(input, sum));
    }
}
