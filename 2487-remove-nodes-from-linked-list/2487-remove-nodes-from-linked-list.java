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
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode temp = head;
        while(temp != null){
            if(st.isEmpty()){
                st.push(temp);
            }
            else if(st.peek().val < temp.val){
                while(!st.isEmpty() && st.peek().val < temp.val){
                    st.pop();
                }
                st.push(temp);
            }
            else{
                st.push(temp);
            }
            temp = temp.next;
        }
        ListNode resHead = null;
        while(!st.isEmpty()){
            temp = st.pop();
            temp.next = resHead;
            resHead = temp;
        }
        return resHead;
    }
}