package BinaryTree.BinarySearchTree;

public class BSearchTreeType extends BinaryTreeType {

    public boolean search(String searchIsbn) {
        NodeType current = root;

        while (current != null) {
            if (searchIsbn.equals(current.info.getIsbn()))
                return true;
            else if (searchIsbn.compareTo(current.info.getIsbn()) < 0)
                current = current.left;
            else
                current = current.right;
        }
        return false;
    }

    
    public void insert(Book book) {
        NodeType newNode = new NodeType(book);            //Create node with desired new insert
        if (root == null) {                                     //Check if tree is empty, if yes, new node is root
            root = newNode;           
            return;                                             
        }

        NodeType current = root;                                
        NodeType trailCurrent = null;

        while (current != null) {                               //Find the correct empty space for new node
            trailCurrent = current;   
            
            String newIsbn = book.getIsbn();
            String currentIsbn = current.info.getIsbn();

            if (newIsbn.equals(currentIsbn)) {                
                System.out.println("The item to be inserted is already in the tree -- duplicates are not allowed.");
                return;
            } else if (newIsbn.compareTo(currentIsbn) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }


        if (book.getIsbn().compareTo(trailCurrent.info.getIsbn()) < 0)                    //put node in correct spot, connect tree to new node
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
