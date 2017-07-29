package i.am.jameshughkim.interviewsPrep.code_rust.linkedList;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Node<T> {
    T data;
    Node<T> next;
}
