class Solution {
    public boolean validTree(int n, int[][] edges) {
    	Map<Integer, List<Integer>> neighbours = new HashMap<>();
    	
    	for (int i = 0; i < n; i++) {
    		neighbours.put(i, new ArrayList<>());
    	}
    	for (int[] arr : edges) {
    		neighbours.get(arr[0]).add(arr[1]);
    		neighbours.get(arr[1]).add(arr[0]);
    	}
    	
    	Set<Integer> visited = new HashSet<>();
    	Queue<int[]> queue = new ArrayDeque<>();
    	
    	queue.add(new int[]{0, -1});
    	visited.add(0);
    	
    	
    	while (!queue.isEmpty()) {
    		int[] curr = queue.poll();
    		int child = curr[0];
    		int parent = curr[1];
    		
    		if (neighbours.get(child) == null) {
    			return false;
    		}
    		
    		for (int num : neighbours.get(child)) {
    			if (num == parent) {
    				continue;
    			}
    			if (visited.contains(num)) {
    				return false;
    			}
    			visited.add(num);
    			queue.add(new int[]{num, child});
    		}
    	}
    	
    	return visited.size() == n;

    }
}
