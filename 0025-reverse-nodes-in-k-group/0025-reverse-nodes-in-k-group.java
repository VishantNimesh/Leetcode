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
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public ListNode getkthNode(ListNode temp, int k) {
        k = k-1;
        while(temp != null && k > 0) {
            k--;
            temp = temp.next;
        }
        return temp;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevLast = null;

        while(temp != null) {
            ListNode kthNode = getkthNode(temp, k);
            if(kthNode == null) {
                if(prevLast != null) {
                    prevLast.next = temp;
                }
                break;
            }
            ListNode nextNode = kthNode.next;
            kthNode.next = null;

            ListNode newHead = reverse(temp);
            if(temp == head) {
                head = newHead;
            } else {
                prevLast.next = newHead;
            }

            prevLast = temp;
            temp.next = nextNode;

            temp = nextNode;
        }
        return head;
    }
}




// ListNode temp = head;
//         ListNode prevLast = null;

//         while(temp != null) {
//             ListNode kthNode = getkthNode(temp, k);
//             if(kthNode == null) {
//                 if(prevLast != null) {
//                     prevLast.next = temp;
//                 }
//                 break;
//             }

//             // ✅ store next group head before cutting
//             ListNode nextNode = kthNode.next;
//             kthNode.next = null;

//             // ✅ reverse current block
//             ListNode newHead = reverse(temp);

//             // ✅ connect previous part with new head
//             if(temp == head) {
//                 head = newHead;
//             } else {
//                 prevLast.next = newHead;
//             }

//             // ✅ connect tail (old temp) with next group
//             prevLast = temp;
//             temp.next = nextNode;

//             // ✅ move temp forward to next group
//             temp = nextNode;
//         }
        // return head;