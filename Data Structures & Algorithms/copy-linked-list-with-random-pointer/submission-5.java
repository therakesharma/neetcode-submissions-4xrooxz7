/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Node curr = head;
        while (curr != null) {
            Node node = new Node(curr.val);
            node.next = curr.next;
            curr.next = node;
            curr = node.next;
        }

        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            if (curr.next.next != null) {
                curr = curr.next.next;
            } else {
                curr = null;
            }
        }

        Node newHead = head.next;
        curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = next.next;
            if (curr.next != null) {
                next.next = curr.next.next;
            }
            curr = curr.next;
        }

        return newHead;
        
    }
}
