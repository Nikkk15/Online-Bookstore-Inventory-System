public class BinaryTree
{
    // Inner Node class
    private class Node
    {
        int element;        // Value stored in node
        Node left, right;   // Left and right child

        Node(int val)
        {
            element = val;
            left = null;
            right = null;
        }

        Node(int val, Node leftChild, Node rightChild)
        {
            element = val;
            left = leftChild;
            right = rightChild;
        }
    }

    private Node root = null;  // Root of the binary tree

    // Method to check if the tree is empty
    public boolean isEmpty()
    {
        return root == null;
    }

    // Method to find the height of the binary tree
    public int height()
    {
        return height(root);
    }

    private int height(Node node)
    {
        if (node == null)
            return -1;  // height of empty tree = -1
        else
            return 1 + Math.max(height(node.left), height(node.right));
    }

    // Method to count total number of nodes
    public int countNodes()
    {
        return countNodes(root);
    }

    private int countNodes(Node node)
    {
        if (node == null)
            return 0;
        else
            return 1 + countNodes(node.left) + countNodes(node.right);
    }

    // Method to count the number of leaf nodes
    public int countLeaves()
    {
        return countLeaves(root);
    }

    private int countLeaves(Node node)
    {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        return countLeaves(node.left) + countLeaves(node.right);
    }

    // Tree Traversals
    public void preorder()
    {
        System.out.print("Preorder: ");
        preorder(root);
        System.out.println();
    }

    private void preorder(Node tree)
    {
        if (tree != null)
        {
            System.out.print(tree.element + " ");
            preorder(tree.left);
            preorder(tree.right);
        }
    }

    public void inorder()
    {
        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();
    }

    private void inorder(Node tree)
    {
        if (tree != null)
        {
            inorder(tree.left);
            System.out.print(tree.element + " ");
            inorder(tree.right);
        }
    }

    public void postorder()
    {
        System.out.print("Postorder: ");
        postorder(root);
        System.out.println();
    }

    private void postorder(Node tree)
    {
        if (tree != null)
        {
            postorder(tree.left);
            postorder(tree.right);
            System.out.print(tree.element + " ");
        }
    }

    // Method to manually build a sample tree
    public void buildSampleTree()
    {
        root = new Node(10,
                new Node(5),
                new Node(15, new Node(12), new Node(20)));
    }

    // Main method to test all methods
    // public static void main(String[] args)
    // {
    //     BinaryTree tree = new BinaryTree();

    //     System.out.println("Is the tree empty? " + tree.isEmpty());

    //     // Build a sample tree
    //     tree.buildSampleTree();

    //     System.out.println("\nAfter building the tree:");
    //     System.out.println("Is the tree empty? " + tree.isEmpty());
    //     System.out.println("Number of nodes: " + tree.countNodes());
    //     System.out.println("Number of leaves: " + tree.countLeaves());
    //     System.out.println("Height of the tree: " + tree.height());

    //     // Test traversals
    //     tree.preorder();
    //     tree.inorder();
    //     tree.postorder();
    // }
}