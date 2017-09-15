package cheat.permutation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// http://www.geeksforgeeks.org/find-possible-words-phone-digits/
public class TelephoneNumber {

    int telNumSize = 8;

    void printTelephoneWords(String telNum) {
        HashMap<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a','b','c'});
        map.put('3', new char[]{'d','e','f'});
        map.put('4', new char[]{'g','h','i'});
        map.put('5', new char[]{'j','k','l'});
        map.put('6', new char[]{'m','n','o'});
        map.put('7', new char[]{'p','q','r'});
        map.put('8', new char[]{'s','t','u'});
        map.put('9', new char[]{'v','w','y'});

        printTelephoneWords(map, "", telNum);
    }

    private void printTelephoneWords(HashMap<Character, char[]> map, String pre, String telNum) {
        if (pre.length() == telNumSize) System.out.println(pre);

        for (int d=0; d < telNum.length(); d++) {
            char digit = telNum.charAt(d);
            for (int c=0; c < map.get(digit).length; c++) {
                printTelephoneWords(map, pre+map.get(digit)[c], telNum.substring(0, c) + telNum.substring(c));
            }
        }
    }


}
