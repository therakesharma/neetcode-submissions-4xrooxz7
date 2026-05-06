class LFUCache {
    Map<Integer, ListNode> keyMap;
    Map<Integer, DoublyLinkedList> freqMap;
    int leastFreq;
    int capacity;

    private class ListNode {
        int key;
        int val;
        int freq;
        ListNode prev;
        ListNode next;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }

    }

    private class DoublyLinkedList {
        ListNode start;
        ListNode end;
        int size;

        DoublyLinkedList() {
            this.start = new ListNode(0, 0);
            this.end = new ListNode(0,0);
            this.end.prev = this.start;
            this.start.next = end;
            this.size = 0;
        }

        public int length() {
            return size;
        }

        public void remove(ListNode node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            size--;
        }

        public void addFront(ListNode node) {
            node.next = this.start.next;
            node.prev = this.start;
            this.start.next.prev = node;
            start.next = node;
            size++;
        }
    }

    public LFUCache(int capacity) {
        this.keyMap = new HashMap<>();
        this.freqMap = new HashMap<>();
        this.capacity = capacity;
        this.leastFreq = 1;
    }

    public void counter(ListNode node) {
        DoublyLinkedList list = freqMap.get(node.freq);
        list.remove(node);
        if (node.freq == leastFreq  && list.length() == 0) {
            leastFreq++;
        }
        node.freq += 1;
        freqMap.putIfAbsent(node.freq, new DoublyLinkedList());
        freqMap.get(node.freq).addFront(node);
    }
    
    public int get(int key) {
        if(!keyMap.containsKey(key)) {
            return -1;
        }
        ListNode node = keyMap.get(key);
        counter(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (keyMap.containsKey(key)) {
            ListNode node = keyMap.get(key);
            node.val = value;
            counter(node);
            return;
        }
        if (keyMap.size() == capacity) {
            DoublyLinkedList list = freqMap.get(leastFreq);
            keyMap.remove(list.end.prev.key);
            list.remove(list.end.prev);
        }
        ListNode node = new ListNode(key, value);
        keyMap.put(key, node);
        freqMap.putIfAbsent(1, new DoublyLinkedList());
        freqMap.get(1).addFront(node);
        leastFreq = 1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */