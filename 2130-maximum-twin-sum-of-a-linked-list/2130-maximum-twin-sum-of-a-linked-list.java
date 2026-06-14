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
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = reverse(slow.next);
        fast = slow.next;
        slow = head;
        int maxSum = 0;
        while(fast != null){
            maxSum = Math.max(maxSum,slow.val+fast.val);
            slow = slow.next;
            fast = fast.next;
        }
        return maxSum;
    }
}