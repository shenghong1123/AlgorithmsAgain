package LeetCode;
import java.util.*;

public class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node != null) {
                    q.offer(node.left);
                    q.offer(node.right);
                    result.append(node.val).append(",");
                }
                else {
                    result.append("null").append(",");
                }
            }
        }
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) return null;
        String[] s = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(s[0]));
        q.offer(root);
        int i = 1;
        while (i < s.length) {
            TreeNode node = q.poll();
            if (!s[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(s[i]));
                q.offer(node.left);
            }
            i++;
            if (!s[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(s[i]));
                q.offer(node.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(5);

        root.left = a;
        root.right = b;
        b.left = c;
        b.right = d;

        SerializeAndDeserializeBinaryTree solution = new SerializeAndDeserializeBinaryTree();
        String s = solution.serialize(root);
        System.out.println(s);
        TreeNode resulult = solution.deserialize(s);
    }
}
