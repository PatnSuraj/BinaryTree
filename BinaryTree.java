import java.util.ArrayList;

/**
 * Class provided by Srini
 * @param <T>
 */
public class BinaryTree<T>{
    private T data;
    private BinaryTree<T> parent;
    private BinaryTree<T> left;
    private BinaryTree<T> right;

    public BinaryTree(){
        parent = left = right = null;
        data = null;
    }


    public void makeRoot(T data){
        if (!isEmpty()){
            System.out.println("Can't make root. Already exists");
        }
        else
            this.data = data;
    }

    public void setData(T data){
        this.data = data;
    }

    public void setLeft(BinaryTree<T> tree){
        left = tree;
    }

    public void setRight(BinaryTree<T> tree){
        right = tree;
    }

    public void setParent(BinaryTree<T> tree){
        parent = tree;
    }

    public T getData(){
        return data;
    }

    public BinaryTree<T> getParent(){
        return parent;
    }

    public BinaryTree<T> getLeft(){
        return left;
    }

    public BinaryTree<T> getRight(){
        return right;
    }

    public void attachLeft(BinaryTree<T> tree){
        if (tree==null) return;
        else if (left!=null || tree.getParent()!=null){
            System.out.println("Can't attach");
            return;
        }
        else{
            tree.setParent(this);
            this.setLeft(tree);
        }
    }

    public void attachRight(BinaryTree<T> tree){
        if (tree==null) return;
        else if (right!=null || tree.getParent()!=null){
            System.out.println("Can't attach");
            return;
        }
        else{
            tree.setParent(this);
            this.setRight(tree);
        }
    }

    public BinaryTree<T> detachLeft(){
        if (this.isEmpty()) return null;
        BinaryTree<T> retLeft = left;
        left = null;
        if (retLeft!=null) retLeft.setParent(null);
        return retLeft;
    }

    public BinaryTree<T> detachRight(){
        if (this.isEmpty()) return null;
        BinaryTree<T> retRight = right;
        right =null;
        if (retRight!=null) retRight.setParent(null);
        return retRight;
    }

    public boolean isEmpty(){
        if (data == null)
            return true;
        else
            return false;
    }

    public void clear(){
        left = right = parent =null;
        data = null;
    }

    public BinaryTree<T> root(){
        if (parent == null)
            return this;
        else{
            BinaryTree<T> next = parent;
            while (next.getParent()!=null)
                next = next.getParent();
            return next;
        }
    }

    // recursive method, nodes returns the number of nodes
    public static<T> int nodes(BinaryTree<T> t){
        // if empty, prints 0
        if(t == null) {
            return 0;
        }
        // recursive call, which returns number of nodes
        return 1+nodes(t.getLeft())+nodes(t.getRight());
    }


    // recursive method, height returns the height of binary tree
    public static<T> int height(BinaryTree<T> t){
        // if empty, returns -1
        if(t == null) {
            return -1;
        }
        // recursive call, finds the maximum height of two subtrees
        return 1+Math.max(height(t.getLeft()),height(t.getRight()));
    }


    // recursive method, isBalanced returns whether or not a binary tree is height balanced
    public static<T> boolean isBalanced(BinaryTree<T> t){
        // returns false if t is null
        if(t == null) {
            return false;
        }
        //  recursive call with either the left and the right subtrees are of the same height,
        //  or the left is one higher than the right, or the right is one higher than the left.
        return isBalanced(t.getLeft()) && isBalanced(t.getRight()) && Math.abs(height(t.getLeft())-height(t.getRight())) <= 1;
    }

    public static <T> void preorder(BinaryTree<T> t){
        if (t!=null){
            System.out.printf("%-13s",t.getData());
            preorder(t.getLeft());
            preorder(t.getRight());
        }
    }

    public static <T> void inorder(BinaryTree<T> t){
        if (t!=null){
            inorder(t.getLeft());
            System.out.printf("%-13s",t.getData());
            inorder(t.getRight());
        }
    }

    public static <T> void postorder(BinaryTree<T> t){
        if (t!=null){
            postorder(t.getLeft());
            postorder(t.getRight());
            System.out.printf("%-13s",t.getData());
        }
    }

    public static <T> void levelorder(BinaryTree<T> t) {
        // returns nothing if null
        if (t == null)
            return;
        // arrayList of type binary
        ArrayList<BinaryTree<T>> agenda = new ArrayList<BinaryTree<T>>();
        //add the root node
        agenda.add(t);

        //while loop to check agenda is is not empty
        while (!agenda.isEmpty()) {
            // removing the first element from the agenda, printing, and adding the children of the node
            System.out.printf("%-13s",agenda.get(0).getData());
            if (agenda.get(0).getLeft() != null) {
                agenda.add(agenda.get(0).getLeft());
            } if (agenda.get(0).getRight() != null) {
                agenda.add(agenda.get(0).getRight());
            }
            // removing the first element from the agenda
            agenda.remove(0);
        }
    }
}
