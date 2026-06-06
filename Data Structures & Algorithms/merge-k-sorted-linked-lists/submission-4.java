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
        if (lists == null) {
            return null;
        }

        ListNode dummy = new ListNode(0, null);
        for (ListNode list : lists) {
            ListNode curr = dummy;

            while (curr.next != null && list != null) {
                if (curr.next.val < list.val) {
                    curr = curr.next;
                } else {
                    ListNode temp = curr.next;
                    curr.next = list;
                    list = list.next;
                    curr = curr.next;
                    curr.next = temp;
                }
            }

            if (list != null) {
                curr.next = list;
            }
        }

        return dummy.next;
        
    }
}
