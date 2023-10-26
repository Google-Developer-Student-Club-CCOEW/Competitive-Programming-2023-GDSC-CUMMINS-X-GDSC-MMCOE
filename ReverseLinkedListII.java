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
    public ListNode reverseBetween(ListNode head, int m, int n) {
         if (head == null || m >= n) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        
        for (int i = 1; i < m; i++) {
            node = node.next;
        }
        ListNode nodeFront = node;
        
        ListNode mNode = node.next; //This isthe mth node. Reserve it for post-processing
        node = mNode.next; // (m+1)th node
        ListNode reversedList = mNode;
        
        for (int countN = m; countN < n; countN++) {
            ListNode temp = node.next;
            node.next = reversedList;
            reversedList = node;
            node = temp;
        }
        // List front and reversed list
        nodeFront.next = reversedList;
        // the current node is the tail
        mNode.next = node;
        
        return dummy.next;
    }
}

/*** Output : 
Test Case 1
Input
head =
[1,2,3,4,5]
left =
2
right =
4
Output
[1,4,3,2,5]
Expected
[1,4,3,2,5]

Test Case 2
Input
head =
[5]
left =
1
right =
1
Output
[5]
Expected
[5]
***/
