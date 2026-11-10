class Solution {
    public int findJudge(int n, int[][] trust) {
        Map<Integer, Integer> incoming = new HashMap<>();
        Map<Integer, Integer> outgoing = new HashMap<>();
        
        for (int [] arr : trust) {
            incoming.put(arr[1], incoming.getOrDefault(arr[1], 0) + 1);
            outgoing.put(arr[0], outgoing.getOrDefault(arr[0], 0) + 1);
        }

        
        for (int i = 1; i <= n; i++) {
            if (incoming.get(i) != null && incoming.get(i) == n - 1 && outgoing.get(i) == null) {
                return i;
            }
        }
        return -1;
        
    }
}