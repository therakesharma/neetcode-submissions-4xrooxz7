class Solution {
    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")) {
    	    return 0;
    	}
    	Set<String> visited = new HashSet<>();
    	for (String str : deadends) {
    		visited.add(str);
    	}
        if (visited.contains("0000")) {
    	    return -1;
    	}
    	
    	Queue<String[]> bfs = new ArrayDeque<>();
    	bfs.add(new String[]{"0000", "1"});
    	
    	while(!bfs.isEmpty()) {
    	    String[] curr = bfs.poll();
    	    String str = curr[0];
    	    int count = Integer.parseInt(curr[1]);
    	    
            //System.out.println("arr -> " + getChilds(str).toString());
    	    for (String child : getChilds(str)) {
    	        if (visited.contains(child)) {
    	            continue;
    	        }
    	        if (child.equals(target)) {
    	            return count;
    	        }
    	        visited.add(child);
    	        bfs.add(new String[]{child, String.valueOf(count + 1)});
    	    }
    	    
    	}
    	
    	return -1;

    }
    
    public List<String> getChilds(String curr) {
    	List<String> result = new ArrayList<>();
    	char[] chars = curr.toCharArray();
    	
    	int first = chars[0] - '0';
    	chars[0] = (char) ('0' + (first + 1) % 10);
    	result.add(new String(chars));
    	chars[0] = (char) ('0' + (first + 9) % 10);
    	result.add(new String(chars));
        chars[0] = (char) (first + '0');
    	
    	first = chars[1] - '0';
    	chars[1] = (char) ('0' + (first + 1) % 10);
    	result.add(new String(chars));
    	chars[1] = (char) ('0' + (first + 9) % 10);
    	result.add(new String(chars));
        chars[1] = (char) (first + '0');
    	
    	first = chars[2] - '0';
    	chars[2] = (char) ('0' + (first + 1) % 10);
    	result.add(new String(chars));
    	chars[2] = (char) ('0' + (first + 9) % 10);
    	result.add(new String(chars));
        chars[2] = (char) (first + '0');
    	
    	first = chars[3] - '0';
    	chars[3] = (char) ('0' + (first + 1) % 10);
    	result.add(new String(chars));
    	chars[3] = (char) ('0' + (first + 9) % 10);
    	result.add(new String(chars));
    	
    	return result;
    	
    }
}