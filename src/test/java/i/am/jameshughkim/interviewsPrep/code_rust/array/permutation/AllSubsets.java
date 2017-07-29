package i.am.jameshughkim.interviewsPrep.code_rust.array.permutation;

import java.util.HashSet;
import java.util.List;

/**
 * Find all subsets of a given set of integers
 *
 * O(2^n) exponential
 */
public class AllSubsets {
    static void get_all_subsets(List<Integer> v, List<HashSet<Integer>> sets) {
        int subsets_count = (int)(Math.pow((double)2, (double)v.size()));
        for (int i = 0; i < subsets_count; ++i) {
            HashSet<Integer> set = new HashSet<Integer>();
            for (int j = 0; j < v.size(); ++j) {
                if (get_bit(i, j) == 1) {
                    int x = v.get(j);
                    set.add(x);
                }
            }
            sets.add(set);
        }
    }

    static int get_bit(int num, int bit) {
        int temp = (1 << bit);
        temp = temp & num;
        if (temp == 0) {
            return 0;
        }
        return 1;
    }
}
