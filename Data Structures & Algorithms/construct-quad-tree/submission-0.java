/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return dfs(grid, grid.length, 0, 0);
    }

    public Node dfs(int[][] grid, int n, int r, int c) {
        boolean isSame = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[r][c] != grid[r + i][c + j]) {
                    isSame = false;
                }
            }
        }
        if (isSame) {
            return new Node(grid[r][c] == 1, true);
        }
        Node topLeft = dfs(grid, n/2, r, c);
        Node topRight = dfs(grid, n/2, r, c + n/2);
        Node bottomLeft = dfs(grid, n/2, r + n/2, c);
        Node bottomRight = dfs(grid, n/2, r + n/2, c + n/2);

        return new Node(grid[r][c] == 1, false, topLeft, topRight, bottomLeft, bottomRight);

    }

}