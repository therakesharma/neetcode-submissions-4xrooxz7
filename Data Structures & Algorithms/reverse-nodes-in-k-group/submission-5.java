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
        if (k <= 1) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;
        ListNode prev = null;

        int i = 0;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
            i++;

            if (i % k == 0) {
                ListNode temp = curr.next;
                curr.next = prev;
                curr = temp;
                curr.next = head;
                prev = null;
            }

        }

        ListNode remain = null;
        while (prev != null) {
            ListNode temp = prev.next;
            prev.next = remain;
            remain = prev;
            prev = temp;
        }

        curr.next = remain;

        return dummy.next;
        
    }
}
