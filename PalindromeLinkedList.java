class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode ptr = head;
        Stack<Integer> stk = new Stack<>();
        while(ptr!=null){
            stk.push(ptr.val);
            ptr=ptr.next;
        }
        while(!stk.isEmpty() && head!=null){
            int n = stk.pop();
            if(head.val!=n)  return false;
            head=head.next;
        }
        return true;
    }
        
}

// Input: head = [1,2,2,1]
// Output: true
// Input: head = [1,2]
// Output: false
