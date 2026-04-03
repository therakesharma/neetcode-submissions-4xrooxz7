class LFUCache {
    private int capacity = 0;
    private Map<Integer, Integer> data = new HashMap<>();
    private Map<Integer, Integer> freq = new HashMap<>();
    private Map<Integer, Set<Integer>> freqData = new HashMap<>();
    private int listFreq = 1;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!data.containsKey(key)) {
            return -1;
        }

        int currFreq = freq.get(key);
        freq.put(key, currFreq + 1);


        Set<Integer> currSet = freqData.get(currFreq);
        currSet.remove(key);

        if (currSet.isEmpty()) {
            freqData.remove(currFreq);
            if (listFreq == currFreq) {
                listFreq++;
            }
        }


        Set<Integer> newSet =freqData.getOrDefault(currFreq + 1, new LinkedHashSet<>());
        newSet.add(key);
        freqData.put(currFreq + 1, newSet);

        return data.get(key);
    }
    
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        if (data.containsKey(key)) {
            data.put(key, value);
            get(key);
            return;
        }


        if (data.size() == capacity) {
            Set<Integer> listFreqSet = freqData.get(listFreq);
            Iterator<Integer> it = listFreqSet.iterator();
            int expireKey = it.next();
            it.remove();
            if (listFreqSet.isEmpty()) {
                freqData.remove(listFreq);
            }
            data.remove(expireKey);
            freq.remove(expireKey);
        }


        data.put(key, value);
        freq.put(key, 1);
        freqData.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);

        listFreq = 1;
    }
}
