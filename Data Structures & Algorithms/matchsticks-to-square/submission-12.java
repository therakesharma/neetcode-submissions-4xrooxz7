class Solution {

    public boolean makesquare(int[] matchsticks) {
    	if (matchsticks.length < 4) {
    		return false;
    	}
    	
    	int sum = Arrays.stream(matchsticks).sum();
    	
    	if (sum % 4 != 0) {
    		return false;
    	}
    	
    	int side = sum / 4;
    	
    	Arrays.sort(matchsticks);
    	
        if (matchsticks[matchsticks.length - 1] > side) {
        	return false;
        }
        
        return backtrack(matchsticks, new int[4], 0);
        
    }
    
    public boolean backtrack(int [] matchsticks, int [] box, int i) {
    	if (i == matchsticks.length) {
    		return box[0] == box[1] && box[1] == box[2] && box[2] == box[3];
    	}
    	
    	for (int j = 0; j < 4; j++) {
    		box[j] += matchsticks[i];
    		if (backtrack(matchsticks, box, i + 1)) {
    			return true;
    		}
    		box[j] -= matchsticks[i];
    	}
    	
    	return false;
    	
    }
}
