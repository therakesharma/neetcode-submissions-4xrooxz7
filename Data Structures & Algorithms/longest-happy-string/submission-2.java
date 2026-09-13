class Solution {
    public String longestDiverseString(int a, int b, int c) {
    	Queue<int []> pq = new PriorityQueue<>((m, n) -> n[1] - m[1]);
    	if (a > 0) {
    		pq.add(new int[]{0, a});
    	}
    	if (b > 0) {
    		pq.add(new int[]{1, b});
    	}
    	if (c > 0) {
    		pq.add(new int[]{2, c});
    	}
    	
    	StringBuilder str = new StringBuilder();
    	while (!pq.isEmpty()) {
    		int [] first = pq.poll();
    		char ch1 = (char) (first[0] + 'a');
    		
    		if (str.length() > 1 
    			&& ch1 == str.charAt(str.length() - 1) 
    			&& ch1 == str.charAt(str.length() - 2)) {
    				if (pq.isEmpty()) {
    					break;
    				}
    				int [] second = pq.poll();
    				char ch2 = (char) (second[0] + 'a');
    				
    				second[1] -= 1;
    				str.append(ch2);
    				
    				if (second[1] > 0) {
    					pq.add(second);
    				}
    				
    				pq.add(first);
    				
    			} else {
    				first[1] -= 1;
    				str.append(ch1);
    				
    				if (first[1] > 0) {
    					pq.add(first);
    				}
    			}
    	}
    	
    	return str.toString();
    }
}
