package cheat.linkedList;

import i.am.jameshughkim.interviewsPrep.code_rust.linkedList.Node;
import i.am.jameshughkim.interviewsPrep.testUtils.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

public class ReverseSinglyLinkedList {
    Node<Integer> reverseSinglyLinkedList(Node<Integer> head) {
        if (head == null || head.next == null) return head;
        Node<Integer> cur = head;
        Node<Integer> prev = cur.next;
        Node<Integer> reversed = null;
        cur.next = null;

        while(prev != null){
            reversed = prev;
            prev = prev.next;
            reversed.next = cur;
            cur = reversed;
        }
        return reversed;
    }

    /*************
     * TESTS
     *************/

    static Node<Integer> fromArray(int[] a) {
        if (a.length == 0) return null;
        Node<Integer> cur = new Node<Integer>(a[0], null);
        Node<Integer> head = cur;

        for (int i=1;i<a.length;i++) {
            cur.next = new Node<Integer>(a[i], null);
            cur = cur.next;
        }
        cur.next = null;
        return head;
    }

    static int[] toArray(Node<Integer> cur) {
        ArrayList<Integer> list = new ArrayList<>();
        while (cur.next != null) {
            list.add(cur.getData());
            cur = cur.next;
        }

        int[] a = new int[list.size()];
        for (int i=0;i<a.length;i++) {
            a[i] = list.get(i);
        }
        return a;
    }

    static Stream<Pair<int[], int[]>> testCases() {
        return Stream.of(
                Pair.of(new int[]{1,2,3,4,5}, new int[]{5,4,3,2,1}),
                Pair.of(new int[]{1}, new int[]{1}),
                Pair.of(new int[]{}, new int[]{}),
                Pair.of(null, null)
        );
    }

    @ParameterizedTest
    @MethodSource(names = "testCases")
    void test(Pair<int[], int[]> testCase) {
        int[] input = testCase.getFirst();
        int[] expected = testCase.getSecond();

        Node<Integer> inputHead = fromArray(input);
        Node<Integer> actualHead = reverseSinglyLinkedList(inputHead);
        int[] actual = toArray(actualHead);

        Assertions.assertArrayEquals(expected, actual);
    }
}
