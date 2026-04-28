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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String num1 = getNumber(l1);
        String num2 = getNumber(l2);

        System.out.println("num1 -> " + num1);
        System.out.println("num2 -> " + num2);


        StringBuilder res = new StringBuilder();
        int len1 = num1.length(), len2 = num2.length();
        int sLen = Math.min(len1, len2);
        int carry = 0, i = 1;

        while (i <= sLen) {
            int n1 = Character.getNumericValue(num1.charAt(len1 - i));
            int n2 = Character.getNumericValue(num2.charAt(len2 - i));
            int sum = (carry + n1 + n2);
            carry = sum / 10;
            res.append(sum % 10);
            i++;
        }


        i = num1.length() - sLen - 1;
        while (i >= 0) {
            int n1 = Character.getNumericValue(num1.charAt(i));
            int sum = (carry + n1);
            carry = sum / 10;
            res.append(sum % 10);
            i--;
        }

        i = num2.length() - sLen - 1;
        while (i >= 0) {
            int n2 = Character.getNumericValue(num2.charAt(i));
            int sum = (carry + n2);
            carry = sum / 10;
            res.append(sum % 10);
            i--;
        }


        if (carry != 0) {
            res.append(carry);
        }

        
        String str = res.toString();
        i = 0;
        ListNode head = new ListNode(Character.getNumericValue(str.charAt(i)));
        ListNode h1 = head;
        i++;
        while (i < str.length()) {
            ListNode h2 = new ListNode(Character.getNumericValue(str.charAt(i)));
            h1.next = h2;
            h1 = h1.next;
            i++;
        }
        return head;
    }

    public String getNumber(ListNode l) {
        StringBuilder num = new StringBuilder();
        while(l != null) {
            num.insert(0, String.valueOf(l.val));
            l = l.next;
        }
        return num.toString();
    }
}
