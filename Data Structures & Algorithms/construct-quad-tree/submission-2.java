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
        return dfs(grid, 0, grid.length, 0, grid.length);
    }

    public Node dfs(int[][] grid, int rowStart, int rowEnd, int columnStart, int columnEnd) {

        // System.out.println("rowStart -> " + rowStart + " rowEnd -> " + rowEnd + " columnStart -> " + columnStart +  " columnEnd ->" + columnEnd);

        if (isSame(grid, rowStart, rowEnd, columnStart, columnEnd)) {
            return new Node(grid[rowStart][columnStart] == 1, true);
        }

        int rowMid = rowStart + (rowEnd - rowStart) / 2;
        int columnMid = columnStart + (columnEnd - columnStart) / 2;

        Node node = new Node(grid[rowStart][columnStart] == 1, false);
        node.topLeft = dfs(grid, rowStart, rowMid, columnStart, columnMid);
        node.topRight = dfs(grid, rowStart, rowMid, columnMid, columnEnd);
        node.bottomLeft = dfs(grid, rowMid, rowEnd, columnStart, columnMid);
        node.bottomRight = dfs(grid, rowMid, rowEnd, columnMid, columnEnd);

        return node;

    }

    public boolean isSame(int [][] grid, int rowStart, int rowEnd, int columnStart, int columnEnd) {
        int val = grid[rowStart][columnStart];
        for (int i = rowStart; i < rowEnd; i++) {
            for (int j = columnStart; j < columnEnd; j++) {
                if (grid[i][j] != val) {
                    return false;
                }
            }
        }
        return true;
    }
}