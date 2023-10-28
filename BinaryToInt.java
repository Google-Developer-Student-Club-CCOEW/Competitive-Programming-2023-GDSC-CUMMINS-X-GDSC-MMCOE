class Solution {
     public int getDecimalValue(ListNode head) {
        // declare string builder to compose binary number
        StringBuilder str = new StringBuilder();
        // iterate over linked list
        while(head != null) {
            // append to string builder value of node on each iteration
            str.append(head.val);
            // move current node to next
            head = head.next;
        }
        // use parseInt to convert string into decimal and return value
        return Integer.parseInt(str.toString(), 2);
    }
}
