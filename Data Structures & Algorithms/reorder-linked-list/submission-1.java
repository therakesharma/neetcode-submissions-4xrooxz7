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
        ListNode middle = head, fast = head;
        while (fast != null && fast.next != null) {
            middle = middle.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = null, curr = middle.next;
        middle.next = null;
        while (curr != null) {
            ListNode node = new ListNode(curr.val, secondHalf);
            secondHalf = node;
            curr = curr.next;
        }

        ListNode firstHalf = head;
        while (secondHalf != null) {
            ListNode temp1 = firstHalf.next;
            ListNode temp2 = secondHalf.next;

            firstHalf.next = secondHalf;
            secondHalf.next = temp1;

            firstHalf = temp1;
            secondHalf = temp2;
        }
    }
}
