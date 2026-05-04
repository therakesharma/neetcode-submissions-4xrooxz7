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
        if (left == right) {
            return head;
        }

        ListNode dummyHead = new ListNode(0, head);
        ListNode preLeft = dummyHead;

        for (int i = 1; i < left; i++) {
            preLeft = preLeft.next;
        }

        ListNode next = null;
        ListNode prev = null;
        ListNode curr = preLeft.next;

        for (int i = 0; i <= right - left; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        preLeft.next.next = curr;
        preLeft.next = prev;
    
        return dummyHead.next;
    
    }
}