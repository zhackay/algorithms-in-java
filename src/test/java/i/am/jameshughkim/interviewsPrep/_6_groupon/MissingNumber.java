package i.am.jameshughkim.interviewsPrep._6_groupon;

/**
 * Given an unsorted list of consecutive integers and one of them is missing. Find one and write test cases
 */
public class MissingNumber {
    int getSum(int n) {
        if (n <= 1) return 0;
        return n + getSum(n-1);
    }

    int getMissingNumber(int[] a, int n) {
        int expectedSum = getSum(n);
        int actualSum = 0;
        for (int num : a) actualSum += num;
        return expectedSum - actualSum;
    }


}
