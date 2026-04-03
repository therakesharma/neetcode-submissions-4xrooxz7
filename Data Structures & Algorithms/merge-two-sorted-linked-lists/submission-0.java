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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node = new ListNode();
        ListNode res = node;
        while (list1 != null && list2 != null) {
            if (list2.val <= list1.val) {
                ListNode newNode = new ListNode(list2.val);
                res.next = newNode;
                res = newNode;
                list2 = list2.next;
            } else {
                ListNode newNode = new ListNode(list1.val);
                res.next = newNode;
                res = newNode;
                list1 = list1.next;
            }
        }
        if (list1 != null) {
            res.next = list1;
        }
        if (list2 != null) {
            res.next = list2;
        }
        return node.next;
    }
}