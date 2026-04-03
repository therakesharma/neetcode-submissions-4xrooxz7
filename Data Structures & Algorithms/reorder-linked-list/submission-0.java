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
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode rev = null, curr = slow.next;
        while (curr != null) {
            ListNode node = new ListNode(curr.val, rev);
            rev = node;
            curr = curr.next;
        }
        slow.next = null;

        ListNode merged = head;
        while (rev != null) {
            ListNode revNext = rev.next;
            ListNode mergedNext = merged.next;

            merged.next = rev;
            rev.next = mergedNext;

            merged = mergedNext;
            rev = revNext;
        }
    }
}
