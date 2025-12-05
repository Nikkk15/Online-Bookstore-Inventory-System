package BinaryTree.BinarySearchTree;

public class BSearchTreeType extends BinaryTreeType {

    public String search(String searchIsbn) {
        NodeType current = root;

        while (current != null) {
            if (searchIsbn.equals(current.info.getIsbn()))
                return "Book found!:\n" + current.info.toString();
            else if (searchIsbn.compareTo(current.info.getIsbn()) < 0)
                current = current.left;
            else
                current = current.right;
        }
        return "Book not found.";
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

    public void deleteNode(String isbn) {
        root = deleteFromTree(root, isbn);
    }

    private NodeType deleteFromTree(NodeType p, String isbn) {
        if (p == null) {
            System.out.println("The item to be deleted is not in the tree.");
            return null;
        }

        String currentIsbn = p.info.getIsbn();

        if (isbn.compareTo(currentIsbn) < 0) {
            p.left = deleteFromTree(p.left, isbn);
        } else if (isbn.compareTo(currentIsbn) > 0) {
            p.right = deleteFromTree(p.right, isbn);
        } else { // found node
            if (p.left == null)
                return p.right;
            else if (p.right == null)
                return p.left;

            // node with two children: replace with inorder predecessor (max in left subtree)
            NodeType temp = p.left;
            while (temp.right != null)
                temp = temp.right;
            p.info = temp.info;
            p.left = deleteFromTree(p.left, temp.info.getIsbn());
        }
    
        return p;
    }

    public void analyzeStock(){
        analyzeStockHelper(root);
    }

    private void analyzeStockHelper(NodeType p){
        if (p != null){
            analyzeStockHelper(p.left);

            if (p.info.getQuantity() < 3) {
                System.out.println(
                    p.info.getTitle() + " | ISBN: " + p.info.getIsbn() + " | Qty: " + p.info.getQuantity()
                );
            }
            
            analyzeStockHelper(p.right);
        }
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

    public void printAllBooks() {
        printInOrder(root);
    }

    private void printInOrder(NodeType p){
        if (p != null) {
            printInOrder(p.left);
            System.out.println(p.info.toString() + "\n");
            printInOrder(p.right);
        }
    }

    public void getPopularGenres() {
        
    }

    private void popularGenres(NodeType p){

        int totalNodes = treeNodeCount();

        if (totalNodes == 0) {
            System.out.println("No books in the inventory.");
            return;
        }

        String[] allGenres = new String[totalNodes];
        int[] index = new int[1];   // index[0] will track how many we filled

        fillGenresArray(root, allGenres, index);
        int n = index[0];
        
    }

    private void fillGenresArray(NodeType node, String[] allGenres, int[] index) {
    if (node == null) 
        return;

    fillGenresArray(node.left, allGenres, index);
    allGenres[index[0]++] = node.info.getGenre();
    fillGenresArray(node.right, allGenres, index);
    }

    public void printAllSales() {
        printSalesInOrder(root);
    }

    private void printSalesInOrder(NodeType p){
        if (p != null) {
            printSalesInOrder(p.left);
            System.out.println(p.info.getTitle() + ": " + p.info.getSales() + " sales.\n");
            printSalesInOrder(p.right);
        }
    }
    public void restock() {
        restockTree(root);
        System.out.println("All books have been restocked to quantity = 3");
    }
    private void restockTree(NodeType p) {
        if (p == null)
            return;
            
        p.info.setQuantity(3);

        restockTree(p.left);
        restockTree(p.right);
    }
    }