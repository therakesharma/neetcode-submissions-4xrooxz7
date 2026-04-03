class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            if (i == 0) {
                leftMax[i] = height[i];
            } else {
                leftMax[i] = Math.max(height[i], leftMax[i - 1]);
            }
        }
        for (int j = height.length - 1; j >= 0; j--) {
            if (j == height.length -1) {
                rightMax[j] = height[j];
            } else {
                rightMax[j] = Math.max(height[j], rightMax[j + 1]);
            }
        }
        for (int i = 0; i < height.length; i++) {
            int area = Math.min(leftMax[i], rightMax[i]) - height[i];
            if (area > 0) {
                result += area;
            }
        }
        return result;
    }
}
