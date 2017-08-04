package cheat.permutation;

import java.util.List;

/**
 * Given a set of n elements, find their Kth permutation (with ordering)
 *  e.g. ABC => {ABC, ACB, BAC, BCB, CAB, CBA} when K = 3, return BAC
 */
public class FindKthPermutation {

    static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n -1 );
    }

    static void find_kth_permutation(List<Character> v, int k, StringBuilder result) {
        if (v.isEmpty()) return;

        int n = v.size();
        int blockSize = factorial(n - 1); // blockSize is number of permutations starting with first digit
        int selected = (k - 1) / blockSize;

        result.append(v.get(selected));
        v.remove(selected);

        k = k - (blockSize * selected);
        find_kth_permutation(v, k, result);
    }
}
