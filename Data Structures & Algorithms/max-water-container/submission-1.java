class Solution {
    public int maxArea(int[] heights) {
        int result = 0;
        int i = 0, j = heights.length - 1;
        while (i < j) {
            int area = Math.min(heights[i], heights[j]) * (j - i);
            result = Math.max(area, result);
            if (heights[i] > heights[j]) {
                j--;
            } else {
                i++;
            }
        }
        return result;
    }
}
