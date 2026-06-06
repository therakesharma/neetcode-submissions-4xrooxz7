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

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length == 0) {
            return null;
        }
        if (inorder.length == 1) {
            return new TreeNode(inorder[0]);
        }
        int val = preorder[0];
        int index = getIndex(inorder, val);

        TreeNode node = new TreeNode(val);

        int [] leftPreorder = Arrays.copyOfRange(preorder, 1, index + 1);
        int [] rightPreorder = Arrays.copyOfRange(preorder, 1 + index, preorder.length);
        int [] leftInorder = Arrays.copyOfRange(inorder, 0, index);
        int [] rightInorder = Arrays.copyOfRange(inorder, index + 1, inorder.length);

        node.left = buildTree(leftPreorder, leftInorder);
        node.right = buildTree(rightPreorder, rightInorder);
        return node;
    }

    public int getIndex(int [] inorder, int val) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }
}
