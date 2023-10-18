/*
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0); // Create a dummy node to handle edge cases.
        dummy.next = head;
        ListNode prevM = dummy;
        
        // Traverse to the (left-1)th node.
        for (int i = 1; i < left; i++) {
            prevM = prevM.next;
        }
        
        ListNode mNode = prevM.next;
        ListNode current = mNode;
        ListNode prev = null;
        ListNode next = null;

        // Reverse the sublist from left to right.
        for (int i = left; i <= right; i++) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        // Connect the reversed sublist to the surrounding nodes.
        prevM.next = prev;
        mNode.next = current;

        return dummy.next;
    }
}
