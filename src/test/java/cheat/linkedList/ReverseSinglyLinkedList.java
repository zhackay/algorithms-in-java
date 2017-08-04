package cheat.linkedList;

import cheat.linkedList.Node;
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
}
