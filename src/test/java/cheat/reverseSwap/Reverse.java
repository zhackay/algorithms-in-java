package cheat.reverseSwap;

public class Reverse {
    void reverse(int[] a, int s, int e) {
        while (s<e) {
            int temp = a[s];
            a[s] = a[e];
            a[e] = temp;
            ++s; ++e;
        }
    }

}
