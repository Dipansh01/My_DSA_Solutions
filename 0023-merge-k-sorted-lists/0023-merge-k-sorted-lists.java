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
    public ListNode merge(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                temp.next = new ListNode(head1.val);
                head1 = head1.next;
            }
            else{
                temp.next = new ListNode(head2.val);
                head2 = head2.next;
            }
            temp = temp.next;
        }
        if(head1 != null){
            temp.next = head1;
        }
        else{
            temp.next = head2;
        }
        return dummy.next;
    }
    public ListNode helper(int st, int ed, ListNode[] lists){
        if(st > ed){
            return null;
        }
        if(st == ed){
            return lists[st];
        }
        int mid = st + (ed-st)/2;
        ListNode temp1 = helper(st,mid,lists);
        ListNode temp2 = helper(mid+1,ed,lists);
         
        return merge(temp1,temp2);
    }
    public ListNode mergeKLists(ListNode[] lists){
        if(lists == null || lists.length == 0){
            return null;
        }
        return helper(0,lists.length-1,lists);
    }
}