class Solution {
	List<List<Integer>> res = new ArrayList<>();
	
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, new ArrayList<>(), new int [nums.length]);
        return res;
    }
    
    public void backtrack(int [] nums, List<Integer> curr, int [] used) {
    	if (curr.size() == nums.length) {
    		res.add(new ArrayList<>(curr));
    		return;
    	}
    	for (int i = 0; i < nums.length; i++) {
    		if (used [i] == 1) {
    			continue;
    		}
    		if ( i > 0 && (nums[i] == nums[i - 1] && used[i - 1] == 0)) {
    			continue;
    		}
    		
    		curr.add(nums[i]);
    		used[i] = 1;
    		
    		backtrack(nums, curr, used);
    		
    		curr.remove(curr.size() - 1);
    		used[i] = 0;
    	}
    }
}