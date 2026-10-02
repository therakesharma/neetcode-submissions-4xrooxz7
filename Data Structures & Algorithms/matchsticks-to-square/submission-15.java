class Solution {
    public boolean makesquare(int[] matchsticks) {
    	Arrays.sort(matchsticks);
    	int sum = Arrays.stream(matchsticks).sum();
    	int side = sum / 4;
    	
    	if (sum % 4 != 0) {
    		return false;
    	}
    	if (matchsticks[matchsticks.length - 1] > side) {
    		return false;
    	}
    	
    	int[] sides = new int[4];
    	
    	return backtrack(matchsticks, sides, side, 0);
    }
    
    public boolean backtrack(int[] matchsticks, int[] sides, int side, int i) {
    	if (i == matchsticks.length) {
    		return true;
    	}
    	
    	for (int j = 0; j < 4; j++) {
			boolean duplicate = false;
            for (int k = 0; k < j; k++) {
                if (sides[k] == sides[j]) { 
                    duplicate = true; 
                    break; 
                }
            }
            if (duplicate) {
                continue;
            };

    		if (sides[j] + matchsticks[i] <= side) {
    			sides[j] += matchsticks[i];
    			if (backtrack(matchsticks, sides, side, i + 1)) {
    				return true;
    			}
    			sides[j] -= matchsticks[i];
    		}
    	}
    	
    	return false;
    	
    }
}