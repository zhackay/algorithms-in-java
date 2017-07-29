package i.am.jameshughkim.interviewsPrep.code_rust.tree;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class BinaryNode<T> {
    T data;
    BinaryNode<T> left;
    BinaryNode<T> right;
}
