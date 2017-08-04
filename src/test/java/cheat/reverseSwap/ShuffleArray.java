package cheat.reverseSwap;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class ShuffleArray {
    void shuffle(int[] a) {
        Random random = new Random();

        for (int i=0;i<a.length;i++) {
            int r = random.nextInt(a.length); // nextInt(/* exclusive bound */)
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    @Test
    void testPrint() {
        int[] a = new int[] {1,2,3,4,5,6,7,8,9,10};
        shuffle(a);
        for (int i=0; i<a.length;i++)
            System.out.print(a[i]+",");

    }
}
