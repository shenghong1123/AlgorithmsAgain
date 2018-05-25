package Tree;
import java.util.*;

public class BST {

    class BSTNode {
        int value;
        BSTNode left;
        BSTNode right;

        BSTNode (int v) {
            value = v;
        }
    }

    BSTNode root;

    public static void TraversePreOrderIterative(BSTNode root) {
        if (root == null) return;
        Stack<BSTNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BSTNode node = stack.pop();
            System.out.println(node.value);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }

    }

    public static void TraversePreOrder(BSTNode root) {
        if (root == null) return;
        System.out.println(root.value);
        TraversePreOrder(root.left);
        TraversePreOrder(root.right);
    }

    public static void TraverseInOrderIterative(BSTNode root) {

        if (root == null) return;
        Stack<BSTNode> stack = new Stack<>();
        BSTNode node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }

        while (stack.size() > 0) {
            node = stack.pop();
            System.out.println(node.value);
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
    }

    public static void TraverseInOrder(BSTNode root) {
        if (root == null) return;
        TraverseInOrder(root.left);
        System.out.println(root.value);
        TraverseInOrder(root.right);
    }

    public static void TraversePostOrder(BSTNode root) {
        if (root == null) return;
        TraversePostOrder(root.left);
        TraversePostOrder(root.right);
        System.out.println(root.value);
    }


    public boolean insert (int num) {

        if (root == null) {
            root = new BSTNode(num);
            return true;
        }

        BSTNode node = new BSTNode(num);
        BSTNode current = root;
        while (current != node) {
            if (num < current.value) {
                if (current.left == null) {
                    current.left = node;
                    return true;
                }
                else {
                    current = current.left;
                }
            }
            else if (num > current.value) {
                if (current.right == null) {
                    current.right = node;
                    return true;
                }
                else {
                    current = current.right;
                }
            }
        }
        return false;
    }

    public BSTNode find(int num) {
        return null;
    }

    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(1);
        bst.insert(7);
        bst.insert(12);
        bst.insert(17);

        BST.TraversePreOrder(bst.root);
        BST.TraversePreOrderIterative(bst.root);
        //BST.TraverseInOrder(bst.root);
        //BST.TraversePostOrder(bst.root);
    }
};
