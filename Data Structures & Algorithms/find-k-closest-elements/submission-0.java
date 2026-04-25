class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Map<Integer, List<Integer>> close = new TreeMap<>();
        List<Integer> res = new ArrayList<>();
        for (int num : arr) {
            List<Integer> list = close.getOrDefault(Math.abs(x - num), new ArrayList<Integer>());
            list.add(num);
            close.put(Math.abs(x - num), list);
        }

        int curr = 0;
        for (int key : close.keySet()) {
            if (curr == k) {
                break;
            }
            List<Integer> list = close.get(key);
            for (int num : list) {
                if (curr == k) {
                    break;
                }
                res.add(num);
                curr++;
            }
        }
        Collections.sort(res);
        return res;
    }
}