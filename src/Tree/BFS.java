package Tree;
import java.util.*;

public class BFS {

    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode (int value) {
            val = value;
        }
    }

    public void traverse(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS bfs = new BFS();
        TreeNode root = bfs.new TreeNode(0);

    }
}
