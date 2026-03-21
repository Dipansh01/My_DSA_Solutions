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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        if(head == null){
            return ans;
        }
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        int minElement = len/k;
        int remElement = len%k;
        temp = head;
        for(int i=0;i<k;i++){
            ans[i] = temp;
            int eachElement = minElement;
            if(remElement != 0){
                eachElement++;
                remElement--;
            }
            ListNode prev = null;
            while(eachElement != 0 && temp != null){
                prev = temp;
                temp = temp.next;
                eachElement--;
            }
            if(prev != null){
                prev.next = null;
            }
        }
        return ans;
    }
}