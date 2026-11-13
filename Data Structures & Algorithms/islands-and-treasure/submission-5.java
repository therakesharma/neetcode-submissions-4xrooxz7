class Solution {
    public void islandsAndTreasure(int[][] grid) {
    	int c = grid[0].length;
    	int r = grid.length;
    	
    	boolean[][] visited = new boolean[r][c];
    	
    	Queue<Integer> queue = new ArrayDeque<>();
    	for(int i = 0; i < r; i++) {
    		for (int j = 0; j < c; j++) {
    			if (grid[i][j] == 0) {
    				queue.add(i * c + j);
    				visited[i][j] = true;
    			}
    		}
    	}
    	
    	int dist = 0;
    	while(!queue.isEmpty()) {
    	    int len = queue.size();
    	    for (int l = 0; l < len; l++) {
    	        int curr = queue.poll();
    		    int i = curr / c;
    		int j = curr % c;
    		
    		grid[i][j] = dist;
    		
    		addInQueue(queue, visited, i + 1, j, r, c, grid);
    		addInQueue(queue, visited, i - 1, j, r, c, grid);
    		addInQueue(queue, visited, i, j + 1, r, c, grid);
    		addInQueue(queue, visited, i, j - 1, r, c, grid);
    	        
    	    }
    		
    		
    		dist++;
    		
    	}
    	  
    }
    
    public void addInQueue(Queue<Integer> queue, boolean[][] visited, int i, int j, int r, int c, int[][] grid) {
    	if (i < 0 || j < 0 || i >= r || j >= c || grid[i][j] == -1 || visited[i][j] == true) {
    		return;
    	}
    	
    	visited[i][j] = true;
    	queue.add(i * c + j);
    	
    }
}
