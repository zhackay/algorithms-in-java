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

    @Test
    void printTelephoneWordsTest(){
        printTelephoneWords("4954552");
    }

    /* https://stackoverflow.com/questions/2344496/how-can-i-print-out-all-possible-letter-combinations-a-given-phone-number-can-re
    */
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        List<String> pre = new ArrayList<>();
        res.add("");

        for(int i=0;i<digits.length();i++){
            String letters;
            for(String str: res) {
                letters = map.get(digits.charAt(i));
                for (int j = 0; j < letters.length(); j++)
                    pre.add(str + letters.charAt(j));
            }
            res = pre;
            pre = new ArrayList<String>();
        }
        return res;
    }

    static final HashMap<Character,String> map = new HashMap<Character,String>(){{
        //put('1',"1");
        put('2',"abc");
        put('3',"def");
        put('4',"ghi");
        put('5',"jkl");
        put('6',"mno");
        put('7',"pqrs");
        put('8',"tuv");
        put('9',"wxyz");
    }} ;
}
