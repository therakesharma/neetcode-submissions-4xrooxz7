class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    	Map<Integer, List<Integer>> map = new HashMap<>();
    	for (int i = 0; i < numCourses; i++) {
    		map.put(i, new ArrayList<>());
    	}
    	for (int[] arr : prerequisites) {
    		List<Integer> list = map.get(arr[0]);
    		list.add(arr[1]);
    		map.put(arr[0], list);
    	}
    	Set<Integer> visited = new HashSet<>();
    	Set<Integer> completed = new HashSet<>();
    	for (int i = 0; i < numCourses; i++) {
    		if (!dfs(i, visited, completed, map)) {
    			return false;
    		}
    	}
    	return true;
    }
    
    public boolean dfs(int curr, Set<Integer> visited, Set<Integer> completed, Map<Integer, List<Integer>> map) {
    	if (visited.contains(curr)) {
    		return false;
    	}
    	if (map.get(curr).isEmpty()) {
    		return true;
    	}
    	if (completed.contains(curr)) {
    		return true;
    	}
    	visited.add(curr);
    	for (int i : map.get(curr)) {
    		if (!dfs(i, visited, completed, map)) {
    			return false;
    		}
    	}
    	visited.remove(curr);
    	completed.add(curr);
    	return true;
    }
}
