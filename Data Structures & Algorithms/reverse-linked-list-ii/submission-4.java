class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next; 
        ListNode next = curr.next;
        while (left < right) {
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
            next = curr.next;
            left++;
        }

        return dummy.next;
        
    }
}