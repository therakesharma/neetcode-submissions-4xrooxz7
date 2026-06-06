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
        return constructQuadTree(grid, grid.length, 0, 0);
    }

    public Node constructQuadTree(int [][] grid, int n, int r, int c) {
        if (isSameValues(grid, n, r, c)) {
            return new Node(grid[r][c] == 1, true);
        }
        Node topLeft = constructQuadTree(grid, n/2, r, c);
        Node topRight = constructQuadTree(grid, n/2, r, c + n/2);
        Node downLeft = constructQuadTree(grid, n/2, r + n/2, c);
        Node downRight = constructQuadTree(grid, n/2, r + n/2, c + n/2);

        return new Node(grid[r][c] == 1, false, topLeft, topRight, downLeft, downRight);

    }

    public boolean isSameValues(int [][] grid, int n, int r, int c) {
        int num = grid[r][c];
        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (grid[i][j] != num) {
                    return false;
                }
            }
        }
        return true;
    }

}