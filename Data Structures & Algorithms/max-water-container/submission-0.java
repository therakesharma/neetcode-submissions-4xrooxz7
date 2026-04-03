class Solution {
    public int maxArea(int[] heights) {
        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                int min = Math.min(heights[i], heights[j]);
                int area = min * (j - i);
                result = Math.max(area, result);
            }
        }
        return result;
    }
}
