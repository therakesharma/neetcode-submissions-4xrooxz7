class Solution {
    public int orangesRotting(int[][] grid) {
    	Queue<Integer> bfs = new ArrayDeque<>();
    	for (int i = 0; i < grid.length; i++) {
    		for (int j = 0; j < grid[0].length; j++) {
    			if (grid[i][j] == 2) {
    				bfs.add(i * grid[0].length + j);
    			}
    		}
    	}
    	
    	int min = -1;
    	while(!bfs.isEmpty()) {
    		int len = bfs.size();
    		//System.out.println("queue " + bfs.toString());
    		for (int x = 0; x < len; x++) {
    			int pos = bfs.poll();
    			int i = pos / grid[0].length;
    			int j = pos % grid[0].length;
    			
    			bfsAdd(grid, bfs, i + 1, j);
    			bfsAdd(grid, bfs, i - 1, j);
    			bfsAdd(grid, bfs, i, j + 1);
    			bfsAdd(grid, bfs, i, j - 1);
    		}
    		min++;
    	}
    	
    	for (int i = 0; i < grid.length; i++) {
    		for (int j = 0; j < grid[0].length; j++) {
    			if (grid[i][j] == 1) {
    				return -1;
    			}
    		}
    	}
    	
    	return min == -1 ? 0 : min;
        
    }
    
    public void bfsAdd(int[][] grid, Queue<Integer> bfs, int i, int j) {
    	if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 2 || grid[i][j] == 0) {
    		return;
    	}
    	grid[i][j] = 0;
    	bfs.add(i * grid[0].length + j);
    }
}
