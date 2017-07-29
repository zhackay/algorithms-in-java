package i.am.jameshughkim.interviewsPrep._1_expedia.algorithms.array;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class ConvertRomanNumberToInteger {
    int toInt(char roman) {
        if (roman == 'I') return 1;
        if (roman == 'V') return 5;
        if (roman == 'X') return 10;
        if (roman == 'L') return 50;
        if (roman == 'C') return 100;
        if (roman == 'D') return 500;
        if (roman == 'M') return 1000;
        return -1;
    }

    int convertRomanToInteger(String roman) {
        // don't know how the Roman works :(
        throw new NotImplementedException();
    }
}
