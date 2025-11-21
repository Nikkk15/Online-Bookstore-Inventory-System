package BinaryTree.BinarySearchTree;
import java.util.Scanner;

public class TestProgram {
    public static void main(String[] args) {
        BSearchTreeType treeRoot = new BSearchTreeType();
        BSearchTreeType otherTreeRoot = new BSearchTreeType();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter integers ending with -999:");
        int num = sc.nextInt();

        while (num != -999) {
            treeRoot.insert(num);
            num = sc.nextInt();
        }

        System.out.print("\nTree nodes in inorder: ");
        treeRoot.inorderTraversal();

        System.out.print("Tree nodes in preorder: ");
        treeRoot.preorderTraversal();

        System.out.print("Tree nodes in postorder: ");
        treeRoot.postorderTraversal();

        System.out.println("The number of single parent nodes in the tree is " + treeRoot.SingleParent());

        treeRoot.swapSubTrees();

        System.out.println("\n**** After the swap operation ****");
        System.out.print("Tree nodes in inorder: ");
        treeRoot.inorderTraversal();
        System.out.print("Tree nodes in preorder: ");
        treeRoot.preorderTraversal();
        System.out.print("Tree nodes in postorder: ");
        treeRoot.postorderTraversal();



        sc.close();
    }
}
