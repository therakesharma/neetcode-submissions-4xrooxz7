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
        ListNode subListLeft = dummy;

        for (int i = 0; i < left - 1; i++) {
            subListLeft = subListLeft.next;
        }

        ListNode subListHead = subListLeft.next;
        ListNode subListTail = subListHead;

        for (int i = 0; i < right - left; i++) {
            subListTail = subListTail.next;
        }

        ListNode nextNode = subListTail.next;
        subListTail.next = null;

        subListLeft.next = reverseList(subListHead);
        subListHead.next = nextNode;

        return dummy.next;
    }

    public ListNode reverseList(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        ListNode newHead = reverseList(node.next);
        node.next.next = node;
        node.next = null;

        return newHead;
    }
}