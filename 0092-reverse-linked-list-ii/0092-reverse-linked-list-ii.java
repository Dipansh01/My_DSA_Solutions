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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || left == right){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode leftPrev = null;
        while(left > 1){
            leftPrev = slow;
            slow = slow.next;
            left--;
        }
        while(right > 1){
            fast = fast.next;
            right--;
        }
        ListNode rightAhead = fast.next;
        fast.next = null;
        ListNode temp = reverse(slow);
        if(leftPrev == null){
            head = temp;
        }
        else{
            leftPrev.next = temp;
        }
        slow.next = rightAhead;
        return head;
    }
}