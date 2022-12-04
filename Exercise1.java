import java.util.ArrayList;
import java.util.Scanner;

// class Exercise1
public class Exercise1 {

    // main method
    public static void main(String[] args) {

        // Trees, stores binary trees of type string
        ArrayList<BinaryTree<String>> trees = new ArrayList<BinaryTree<String>>();
        // agenda, stores the binary trees of type string
        ArrayList<BinaryTree<String>> agenda = new ArrayList<BinaryTree<String>>();

        Scanner in = new Scanner(System.in);
        // asking the user to enter input
        System.out.print("Enter name or done: ");
        String user_Input = in.next();

        // while loop for group of inputs
        while(!user_Input.equalsIgnoreCase("done")){
            // creating a new Binary tree for making all the input values together
            BinaryTree<String> inputValues = new BinaryTree<String>();
            inputValues.makeRoot(user_Input);
            // storing the input values in tree
            trees.add(inputValues);
            // accepts input until user enters done
            System.out.print("Enter name or done: ");
            user_Input = in.next();
        }

        // Binary tree reference true root
        BinaryTree trueroot;
        // removing first element from tree and stores in trueroot
        trueroot = trees.remove(0);
        // adding trueroot to agenda
        agenda.add(trueroot);


        while(!trees.isEmpty()){

            // Removing elements at the front of agenda and trees
            BinaryTree<String> binaryTreeAgenda = agenda.remove(0);
            BinaryTree<String> binaryTreeTrees = trees.remove(0);

            // Attach the element from trees to the left of the element from agenda
            binaryTreeAgenda.attachLeft(binaryTreeTrees);

            // Add the same element from trees that you just attached to agenda
            agenda.add(binaryTreeTrees);

            // If tree is still not empty
            if(!trees.isEmpty()){
                // remove the first element from trees
                binaryTreeTrees = trees.remove(0);

                // attach it to the right of the element from agenda
                binaryTreeAgenda.attachRight(binaryTreeTrees);

                // Add the same element from trees that you just attached to agenda
                agenda.add(binaryTreeTrees);
            }

        }

        // Output of height and nodes
        System.out.println("\nHeight of the tree is: "+BinaryTree.height(trueroot));
        System.out.println("Number of nodes in the tree is: "+BinaryTree.nodes(trueroot)+"\n");

        // Output of traversals
        System.out.print("Inorder:      ");
        BinaryTree.inorder(trueroot);
        System.out.print("\nPreorder:     ");
        BinaryTree.preorder(trueroot);
        System.out.print("\nPostOrder:    ");
        BinaryTree.postorder(trueroot);
        System.out.print("\nLevel order:  ");
        BinaryTree.levelorder(trueroot);
        System.out.println();

        // Checking whether the tree is height balanced or not
        System.out.printf("\nThe tree is height balanced... %s\n",
                BinaryTree.isBalanced(trueroot)? "Yes!": "No.");

    }
}