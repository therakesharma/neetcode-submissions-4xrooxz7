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
        Queue<ListNode> minPQ = new PriorityQueue<>((a, b) ->  a.val - b.val);
        for (ListNode list : lists) {
            minPQ.offer(list);
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!minPQ.isEmpty()) {
            ListNode node = minPQ.poll();
            curr.next = node;
            curr = curr.next;
            if (node.next != null) {
                minPQ.offer(node.next);
            }
        }
        return dummy.next;
    }
}
