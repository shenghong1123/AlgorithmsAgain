package Algorithms;

/*
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {

        MaximumDepthOfBinaryTree solution = new MaximumDepthOfBinaryTree();

        TreeNode a = new TreeNode (1);
        TreeNode b = new TreeNode (2);
        TreeNode c = new TreeNode (3);
        TreeNode d = new TreeNode (4);
        TreeNode e = new TreeNode (5);

        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;

        System.out.println(solution.maxDepth(a));

    }
}
