package cheat.tree;

public class CheckIfTwoBinaryTreesAreIdentical {

    /*
    Case 1: node1 & node2 are null -> identical
    Case 2: node1 & node2 are both not null -> identical
    Case 3: either node1 or node2 is null and the other is not -> different
     */
    boolean isIdentical(BinaryNode node1, BinaryNode node2) {
        if (node1 == null && node2 == null) return true;
        else if (node1 != null && node2 != null)
            return (node1.data == node2.data) &&
                isIdentical(node1.getLeft(), node2.getLeft()) &&
                isIdentical(node1.getRight(), node2.getRight());
        return false;
    }
}
