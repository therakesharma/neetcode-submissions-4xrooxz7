class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Integer> nodeToIndex = new HashMap<>();
        Map<Integer, Integer> indexToRandomIndex = new HashMap<>();

        Node curr = head;
        int index = 0;

        while (curr != null) {
            nodeToIndex.put(curr, index);
            curr = curr.next;
            index++;
        }

        curr = head;
        index = 0;
        while (curr != null) {
            if (curr.random != null) {
                indexToRandomIndex.put(index, nodeToIndex.get(curr.random));
            } else {
                indexToRandomIndex.put(index, null);
            }
            curr = curr.next;
            index++;
        }

        Node newHead = new Node(head.val);
        Map<Integer, Node> indexToNewNode = new HashMap<>();

        Node newCurr = newHead;
        curr = head;
        index = 0;

        while (curr != null) {
            indexToNewNode.put(index, newCurr);

            if (curr.next != null) {
                newCurr.next = new Node(curr.next.val);
            }

            curr = curr.next;
            newCurr = newCurr.next;
            index++;
        }

        newCurr = newHead;
        index = 0;

        while (newCurr != null) {
            Integer randomIndex = indexToRandomIndex.get(index);
            if (randomIndex != null) {
                newCurr.random = indexToNewNode.get(randomIndex);
            } else {
                newCurr.random = null;
            }
            newCurr = newCurr.next;
            index++;
        }

        return newHead;
    }
}