package BinaryTree.BinarySearchTree;

public class NodeType {
    public Book info;
    public NodeType left;
    public NodeType right;

    public NodeType(Book info) {
        this.info = info;
        this.left = null;
        this.right = null;
    }
}
