class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            leftMax[i] = i == 0 
            ? height[i] 
            : Math.max(height[i], leftMax[i - 1]);
        }
        for (int i = height.length - 1; i >= 0; i--) {
            rightMax[i] = i == height.length - 1
            ? height[i]
            : Math.max(height[i], rightMax[i + 1]);
        }
        for (int i = 0; i < height.length; i++) {
            int area = Math.min(leftMax[i], rightMax[i]) - height[i];
            result += (area > 0) ? area : 0;
        }
        return result;
    }
}
