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
    private int i = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> arr = new ArrayList<>();
        doSerialization(root, arr);
        return String.join(",", arr);
    }

    public void doSerialization(TreeNode root,List arr) {
        if (root == null) {
            arr.add("N");
            return;
        }
        arr.add(String.valueOf(root.val));
        doSerialization(root.left, arr);
        doSerialization(root.right, arr);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        i = 0;
        return doDerialization(arr);
    }

    public TreeNode doDerialization(String[] arr) {
        if ("N".equals(arr[i])) {
            i++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(arr[i++]));
        node.left = doDerialization(arr);
        node.right = doDerialization(arr);
        return node;
    } 
}
