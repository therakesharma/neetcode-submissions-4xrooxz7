class Solution {
    public String reorganizeString(String s) {
    	Map<Character, Integer> count = new HashMap<>();
    	
    	for (char ch : s.toCharArray()) {
    		count.put(ch, count.getOrDefault(ch, 0) + 1);
    	}
    
    	Queue<Character> pq = new PriorityQueue<>((p, q) -> count.get(q) - count.get(p));
    	
    	pq.addAll(count.keySet());
    	
    	if (count.get(pq.peek()) > ( (s.length() + 1) / 2)) {
    		return "";
    	}
    	
    	StringBuilder res = new StringBuilder();
    	char ch = pq.poll();
    	res.append(ch);
    	count.put(ch, count.get(ch) - 1);
    	
    	while (!pq.isEmpty()) {
    		char curr = pq.poll();
    		if (count.get(ch) > 0) {
    			pq.add(ch);
    		}
    		res.append(curr);
    		ch = curr;
    		count.put(ch, count.get(ch) - 1);
    	}
    	
    	return res.toString();
    	
    }
}