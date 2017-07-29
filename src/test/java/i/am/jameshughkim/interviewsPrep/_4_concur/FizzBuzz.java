package i.am.jameshughkim.interviewsPrep._4_concur;

import org.junit.jupiter.api.Test;

public class FizzBuzz {
    void fizzBuzz(int n) {
        while (n > 0) {
            if (n % 3 == 0 && n % 5 == 0) System.out.println(n + ":FizzBuzz");
            else if (n % 3 == 0) System.out.println(n + ":Fizz");
            else if (n % 5 == 0) System.out.println(n + ":Buzz");
            n--;
        }
    }

    @Test
    void printFizzBuzz() {
        fizzBuzz(15);
    }
}


