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
    int i = 0;
    public TreeNode deserialize(String data) {
        String [] strs = data.split(",");
        System.out.println("strs -> " + Arrays.toString(strs));
        return dfs(strs);
    }

    public TreeNode dfs(String [] strs) {
        System.out.println("i -> " + i);
        if (strs[i].equals("N")) {
            i++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(strs[i]));
        i++;
        node.left = dfs(strs);
        node.right = dfs(strs);
        return node;
    }

}
