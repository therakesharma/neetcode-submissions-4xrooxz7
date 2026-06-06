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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;

        int count = 0;
        while (curr.next != null) {
            curr = curr.next;
            count++;
        }

        ListNode prev;
        ListNode next;
        curr = dummy;

        while (count >= k) {
            prev = curr;
            curr = prev.next;
            for (int i = 1; i < k; i++) {
                next = curr.next;
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
            }
            count -= k;
        }

        return dummy.next;
        
    }
}