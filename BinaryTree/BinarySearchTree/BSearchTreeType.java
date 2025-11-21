package BinaryTree.BinarySearchTree;

public class BSearchTreeType extends BinaryTreeType {

    @Override
    public boolean search(int searchItem) {
        NodeType current = root;
        while (current != null) {
            if (searchItem == current.value)
                return true;
            else if (searchItem < current.value)
                current = current.left;
            else
                current = current.right;
        }
        return false;
    }

    @Override
    public void insert(int insertItem) {
        NodeType newNode = new NodeType(insertItem);
        if (root == null) {
            root = newNode;
            return;
        }

        NodeType current = root;
        NodeType trailCurrent = null;

        while (current != null) {
            trailCurrent = current;
            if (insertItem == current.value) {
                System.out.println("The item to be inserted is already in the tree -- duplicates are not allowed.");
                return;
            } else if (insertItem < current.value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (insertItem < trailCurrent.value)
            trailCurrent.left = newNode;
        else
            trailCurrent.right = newNode;
    }

    @Override
    public void deleteNode(int deleteItem) {
        root = deleteFromTree(root, deleteItem);
    }

    private NodeType deleteFromTree(NodeType p, int deleteItem) {
        if (p == null) {
            System.out.println("The item to be deleted is not in the tree.");
            return null;
        }

        if (deleteItem < p.value) {
            p.left = deleteFromTree(p.left, deleteItem);
        } else if (deleteItem > p.value) {
            p.right = deleteFromTree(p.right, deleteItem);
        } else { // found node
            if (p.left == null)
                return p.right;
            else if (p.right == null)
                return p.left;

            // node with two children: replace with inorder predecessor (max in left subtree)
            NodeType temp = p.left;
            while (temp.right != null)
                temp = temp.right;
            p.value = temp.value;
            p.left = deleteFromTree(p.left, temp.value);
        }

        return p;
    }

    public void swapSubTrees(){
        swaptrees(root);
    }

    public void swaptrees(NodeType p) {
        if (p == null)
            return;
        
        NodeType temp = p.left;
        p.left = p.right;
        p.right = temp;

        swaptrees(p.left);
        swaptrees(p.right);
    }
}
