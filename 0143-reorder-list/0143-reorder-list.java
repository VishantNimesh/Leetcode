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
    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        int length = 0;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
            length++;
        }
        curr = head;
        for (int i = 0; i < length / 2; i++) {
            ListNode end = stack.pop(); 
            ListNode nextNode = curr.next;
            curr.next = end;
            end.next = nextNode;
            
            curr = nextNode;
        }
        curr.next = null; 
    }
}