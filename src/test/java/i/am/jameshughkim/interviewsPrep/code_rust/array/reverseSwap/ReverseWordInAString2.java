package i.am.jameshughkim.interviewsPrep.code_rust.array.reverseSwap;

/**
 * Given a sentence, reverse order of words
 *
 * "Hello World" => "World Hello"
 */
public class ReverseWordInAString2 {
    void reverse(char[] s) {
        for (int i=0, j=s.length-1; i<s.length/2; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }

    static void reverseWords(char[] s) {

    }
}
