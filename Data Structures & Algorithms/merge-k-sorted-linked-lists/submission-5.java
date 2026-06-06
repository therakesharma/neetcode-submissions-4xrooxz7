/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((p, q) -> p.val - q.val);
        for (ListNode list : lists) {
            minHeap.add(list);
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!minHeap.isEmpty()) {
            curr.next = minHeap.poll();
            curr = curr.next;
            if (curr.next != null) {
                minHeap.add(curr.next);
            }
        }

        return dummy.next;

    }
}
