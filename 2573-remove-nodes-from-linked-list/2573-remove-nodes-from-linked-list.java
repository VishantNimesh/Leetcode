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
    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }
    public ListNode removeNodes(ListNode head) {
        head = reverse(head);
        ListNode dummy = new ListNode(0);
        ListNode curr = head, prev = dummy;
        int maxEl = Integer.MIN_VALUE;
        
        while (curr != null) {
            if (curr.val >= maxEl) {
                maxEl = curr.val;
                prev.next = curr;
                prev = curr;
            }
            curr = curr.next;
        }
        prev.next = null;
        return reverse(dummy.next);
    }
}