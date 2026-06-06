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
        ListNode newHead = dummy;
        ListNode prev = null;
        int i = 0;

        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
            i++;

            if (i % k == 0) {
                ListNode temp1 = dummy.next;
                dummy.next = prev;
                dummy = temp1;
                dummy.next = head;
                prev = null;
            }

        }

        ListNode newPrev = null;
        while (prev != null) {
            ListNode temp2 = prev.next;
            prev.next = newPrev;
            newPrev = prev;
            prev = temp2;
        }

        dummy.next = newPrev;
        return newHead.next;
        
    }
}
