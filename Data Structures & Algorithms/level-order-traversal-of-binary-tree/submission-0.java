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
    class Pair {
        TreeNode node;
        int depth;
        Pair(TreeNode node,int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(root, 0));

        while(!queue.isEmpty()) {
            List<Integer> innerList;
            Pair curr = queue.poll();
            TreeNode parent = curr.node;

            if (result.size() <= curr.depth) {
                innerList = new ArrayList<>();
                result.add(innerList);
            } else {
                innerList = result.get(curr.depth);
            }
            innerList.add(parent.val);

            if (parent.left != null) {
                Pair node = new Pair(parent.left, curr.depth + 1);
                queue.offer(node);
            }
            if (parent.right != null) {
                Pair node = new Pair(parent.right, curr.depth + 1);
                queue.offer(node);
            }
        }

        return result;
        
    }
}
