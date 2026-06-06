/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "N";
        }
        int curr = root.val;
        String left = serialize(root.left);
        String right = serialize(root.right);
        return curr + "," + left + "," + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String [] strs = data.split(",");
        return dfs(strs, new int[]{0});
    }

    public TreeNode dfs(String [] strs, int [] i) {
        if (strs[i[0]].equals("N")) {
            i[0] += 1;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(strs[i[0]]));
        i[0] += 1;
        node.left = dfs(strs, i);
        node.right = dfs(strs, i);
        return node;
    }

}
