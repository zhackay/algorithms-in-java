package cheat.linkedList;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Node<T> {
    T data;
    Node<T> next;
}
