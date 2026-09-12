class Solution {
    public String reorganizeString(String s) {
    	Map<Integer, Integer> count = new HashMap<>();
    	for (char ch : s.toCharArray()) {
    		count.put(ch - 'a', count.getOrDefault(ch - 'a', 0) + 1);
    	}
    
    	Queue<int []> pq = new PriorityQueue<>((p, q) -> q[1] - p[1]);
    	for (int i : count.keySet()) {
    		pq.add(new int[]{i, count.get(i)});
    	}
    	
    	if (pq.peek()[1] > (s.length() + 1) / 2 ) {
    		return "";
    	}
    	
    	StringBuilder res = new StringBuilder();
    	int [] peak = null;
    	
    	while (!pq.isEmpty()) {
    		int [] curr = pq.poll();
    		if (peak != null && peak[1] > 0) {
    			pq.add(peak);
    		}
    		res.append((char) (curr[0] + 'a'));
    		curr[1] -= 1;
    		peak = curr;
    	}
    	
    	return res.toString();
    	
    }
}