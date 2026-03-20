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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = {-1,-1};
        int idx = 1;
        int fidx = -1;
        int lidx = -1;
        int minDis = Integer.MAX_VALUE;
        ListNode a = head;
        ListNode b = head.next;
        ListNode c = head.next.next;
        if(c == null){
            return ans;
        }
        while(c != null){
            if((a.val<b.val && b.val>c.val) || (a.val>b.val && b.val<c.val)){
                if(fidx == -1){
                    fidx = idx;
                }
                if(lidx != -1){
                    int dist = idx - lidx;
                    minDis = Math.min(minDis,dist);
                }
                lidx = idx;
            }
            idx++;
            a = a.next;
            b = b.next;
            c = c.next;
        }
        int maxDis = lidx - fidx;
        if(maxDis == 0){
            maxDis = -1;
        }
        if(minDis == Integer.MAX_VALUE){
            minDis = -1;
        }
        ans[0] = minDis;
        ans[1] = maxDis;
        return ans;
    }
}