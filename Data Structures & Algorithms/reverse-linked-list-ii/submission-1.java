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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode preLeft = dummy;

        for (int i = 1; i < left; i++) {
            preLeft = preLeft.next;
        }

        ListNode next = null;
        ListNode prev = null;
        ListNode curr = preLeft.next;

        for (int i = 1; i <= right - left + 1; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        preLeft.next.next = curr;
        preLeft.next = prev;

        return dummy.next;

    }
}