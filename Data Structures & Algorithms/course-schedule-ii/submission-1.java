class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
    	Map<Integer, List<Integer>> graph = new HashMap<>();
    	for (int i = 0; i < numCourses; i++) {
    		graph.put(i, new ArrayList<>());
    	}
    	for (int[] arr : prerequisites) {
    		List<Integer> list = graph.get(arr[0]);
    		list.add(arr[1]);
    	}
    	
    	Set<Integer> visited = new HashSet<>(); 
    	Set<Integer> completed = new LinkedHashSet<>();
    	    	
    	for (int i = 0; i < numCourses; i++){
    		if (!dfs(i, graph, visited, completed)) {
    			return new int[0];
    		}
    		completed.add(i);
    	}
    	
    	
    	int[] result = new int[completed.size()];
    	int i = 0;
    	for (int num : completed) {
    		result[i] = num;
    		i++;
    	}
    	
    	return result;
        
    }
    
    public boolean dfs(int curr, Map<Integer, List<Integer>> graph, Set<Integer> visited, Set<Integer> completed) {
    	if (visited.contains(curr)) {
    		return false;
    	}
    	if (graph.get(curr) == null) {
    		return true;
    	}
    	if (completed.contains(curr)) {
    		return true;
    	}
    	visited.add(curr);
    	for (int num : graph.get(curr)) {
    		if(!dfs(num, graph, visited, completed)) {
    			return false;
    		}
    	}
    	
    	visited.remove(curr);
    	completed.add(curr);
    	return true;
    }
}
