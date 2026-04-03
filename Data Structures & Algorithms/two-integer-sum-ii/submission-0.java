class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= numbers.length; i++) {
            map.put(numbers[i-1], i);
        }
        int[] result = new int[2];
        for (int i = 1; i <= numbers.length; i++) {
            int diff = target - numbers[i -1];
            if (map.containsKey(diff) && map.get(diff) != i) {
                int first = map.get(diff) < i ? map.get(diff) :  i;
                int second = first == i ? map.get(diff) : i;
                result[0] = first;
                result[1] = second;
            }
        }
        return result;
    }
}
