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
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode ahead = head.next;
            head.next = prev;
            prev = head;
            head = ahead;
        }
        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        ListNode temp1 = reverse(l1);
        ListNode temp2 = reverse(l2);
        int carry = 0;
        while(temp1!=null || temp2!=null){
            int sum = carry;
            if(temp1 != null){
                sum += temp1.val;
            }
            if(temp2 != null){
                sum += temp2.val;
            }
            temp.next = new ListNode(sum%10);
            temp = temp.next;
            carry = sum/10;
            if(temp1 != null){
                temp1 = temp1.next;
            }
            if(temp2 != null){
                temp2 = temp2.next;
            }
        }
        if(carry != 0){
            temp.next = new ListNode(carry);
        }
        return reverse(dummy.next);
    }
}