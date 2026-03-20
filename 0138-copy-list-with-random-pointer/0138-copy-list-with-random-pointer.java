/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head){
        if(head == null){
            return null;
        }
        Node temp = head;
        while(temp != null){
            Node newNode = new Node(temp.val,temp.next);
            temp.next = newNode;
            temp = newNode.next;
        }
        temp = head;
        while(temp != null){
            if(temp.random == null){
                temp.next.random = null;
            }
            else{
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }
        Node oldHead = head;
        Node newHead = head.next;
        Node temp1 = oldHead;
        Node temp2 = newHead;
        while(temp1 != null){
            temp1.next = temp2.next;
            temp1 = temp1.next;
            if(temp1 == null){
                break;
            }
            temp2.next = temp1.next;
            temp2 = temp2.next;
        }
        return newHead;
    }
}