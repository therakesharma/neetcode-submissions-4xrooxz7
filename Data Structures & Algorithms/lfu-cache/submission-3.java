class LFUCache {
    Map<Integer, ListNode> keyNodeMap;
    Map<Integer, DoublyLinkedList> freqListMap;
    int freq, capacity;

    private class ListNode {
        int key;
        int val;
        int freq;
        ListNode prev;
        ListNode next;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            freq = 1;
        }
    }


    private class DoublyLinkedList {
        ListNode start;
        ListNode end;
        int size;

        DoublyLinkedList() {
            start = new ListNode(0, 0);
            end = new ListNode(0, 0);
            start.next = end;
            end.prev = start;
            size = 0;
        }


        public void remove(ListNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        public void addFront(ListNode node) {
            node.next = start.next;
            start.next.prev = node;
            node.prev = start;
            start.next = node;
            size++;
        }

        public int getSize() {
            return size;
        }

    }

    public LFUCache(int capacity) {
        keyNodeMap = new HashMap<>();
        freqListMap = new HashMap<>();
        this.capacity = capacity;
        freq = 0;
    }

    public void manageLFU(ListNode node) {
        DoublyLinkedList list = freqListMap.get(node.freq);
        list.remove(node);

        if (list.getSize() == 0 && node.freq == freq) {
            freq++;
        }

        node.freq++;
        freqListMap.putIfAbsent(node.freq, new DoublyLinkedList());
        freqListMap.get(node.freq).addFront(node);
    }
    
    public int get(int key) {
        if (!keyNodeMap.containsKey(key)) {
            return -1;  
        }

        ListNode node = keyNodeMap.get(key);
        manageLFU(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (keyNodeMap.containsKey(key)) {
            ListNode node = keyNodeMap.get(key);
            node.val = value;
            manageLFU(node);
            return;
        }

        if (keyNodeMap.size() == capacity) {
            DoublyLinkedList lfu = freqListMap.get(freq);
            ListNode lfuNode = lfu.end.prev;
            keyNodeMap.remove(lfuNode.key);
            lfu.remove(lfuNode);
        }

        ListNode node = new ListNode(key, value);
        keyNodeMap.put(key, node);
        freqListMap.putIfAbsent(1, new DoublyLinkedList());
        freqListMap.get(1).addFront(node);
        freq = 1;
        
    }
}