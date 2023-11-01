public class BinaryTree<T> {
    
    /* Instance variables: */
    private T data;
    private BinaryTree<T> parent;
    private BinaryTree<T> left;
    private BinaryTree<T> right;

    /* Constructor: */
    public BinaryTree() {
        parent = left = right = null;
        data = null;
    }

    /* 
     * Creates a single node tree with the specified data in that node.
     * Time complexity: O(1)  
     */
    public void makeRoot(T data) {
        if (!isEmpty()) {
            System.out.println("Could not make root; already exits.");
        } else {
            this.data = data;
        }
    }

    public boolean isEmpty() {
        return data == null;
    }

    public void clear() {
        left = right = parent = null;
        data = null;
    }

    /*
     * Sets the data, left, right, and parent
     */
    public void setData(T data) {
        this.data = data;
    }

    public void setLeft(BinaryTree<T> tree) {
        left = tree;
    }

    public void setRight(BinaryTree<T> tree) {
        right = tree;
    }

    public void setParent(BinaryTree<T> tree) {
        parent = tree;
    }

    public T getData() {
        return data;
    }

    public BinaryTree<T> getParent() {
        return parent;
    }

    public BinaryTree<T> getLeft() {
        return left;
    }

    public BinaryTree<T> getRight() {
        return right;
    }

    public void attachLeft(BinaryTree<T> tree) {
        if (this.isEmpty() || tree == null) {
            return;
        } else if (this.left != null || tree.getParent() != null) {
            System.out.println("Could not attach.");
            return;
        } else {
            tree.setParent(this);
            this.setLeft (tree);
        }
    }

    public void attachRight(BinaryTree<T> tree) {
        if (this.isEmpty() || tree == null) {
            return;
        } else if (this.right != null || tree.getParent() != null) {
            System.out.println("Could not attach.");
            return;
        } else {
            tree.setParent(this);
            this.setRight (tree);
        }
    }

    public BinaryTree<T> detachLeft() {
        if (this.isEmpty()) return null;

        BinaryTree<T> retLeft = left;
        left = null;

        if (retLeft != null) retLeft.setParent(null);
        return retLeft;
    }

    public BinaryTree<T> detachRight() {
        if (this.isEmpty()) return null;

        BinaryTree<T> retRight = right;
        right = null;

        if (retRight != null) retRight.setParent(null);

        return retRight;
    }

    /* Implement recursive version - if statements instead of while loop */
    public BinaryTree<T> root() {
        if (this.isEmpty()) return null;
        if (this.parent == null) return this;

        BinaryTree<T> next = this.parent;
        while (next.getParent() != null) next = next.getParent();

        return next;
    }

    /* Traverse the tree: */

    /* Preorder */
    public static <T> void preOrder(BinaryTree<T> t) {
        if (t != null) {
            System.out.print(t.getData() + "\t");
            preOrder(t.getLeft());
            preOrder(t.getRight());
        }
    }

    /* Postorder */
    public static <T> void postOrder(BinaryTree<T> t) {
        if (t != null) {
            postOrder(t.getLeft());
            postOrder(t.getRight());
            System.out.print(t.getData() + "\t");
        }
    }

    /* Inorder */
    public static <T> void inOrder(BinaryTree<T> t) {
        if (t != null) {
            inOrder(t.getLeft());
            System.out.print(t.getData() + "\t");
            inOrder(t.getRight());
        }
    }
}