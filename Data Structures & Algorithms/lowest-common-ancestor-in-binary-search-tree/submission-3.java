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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> pPaths = getPath(root, p);
        Queue<TreeNode> qPaths = getPath(root, q);
        TreeNode lca = root;

        System.out.println("pPaths -> " + pPaths.toString());
        System.out.println("qPaths -> " + qPaths.toString());

        while (!pPaths.isEmpty() && !qPaths.isEmpty()) {
            TreeNode pPath = pPaths.poll();
            TreeNode qPath = qPaths.poll();

            if (pPath.val == qPath.val) {
                lca = qPath;
            }
        }

        return lca;
        
    }

    public Queue<TreeNode> getPath(TreeNode root, TreeNode child) {
        Queue<TreeNode> path = new ArrayDeque<>();

        Queue<TreeNode> tree = new ArrayDeque<>();
        tree.offer(root);
        
        while (!tree.isEmpty()) {
            TreeNode curr = tree.poll();
            path.offer(curr);

            if (child.val < curr.val) {
                tree.offer(curr.left);
            } else if (child.val > curr.val) {
                tree.offer(curr.right);
            } else {
                break;
            }
        }

        return path;

    }


}
