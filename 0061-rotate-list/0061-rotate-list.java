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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp1 = head;
        int len = 1;
        while(temp1.next != null){
            temp1 = temp1.next;
            len++;
        }
        int dif = k % len;
        if(dif == 0){
            return head;
        }
        ListNode temp2 = head;
        for(int i=0;i<len-dif-1;i++){
            temp2 = temp2.next;
        }
        ListNode newHead= temp2.next;
        temp2.next = null;
        temp1.next = head;

        return newHead;
    }
}