class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode big = new ListNode(0);
        ListNode ptr1 = small;
        ListNode ptr2 = big;
        
        while(head!=null){
            if(head.val<x){
                ptr1.next=head;
                ptr1=ptr1.next;
            }
            else{
                ptr2.next=head;
            ptr2=ptr2.next;
            }
            head=head.next;
            
        }
        
        ptr2.next=null;
        ptr1.next=big.next;
        return small.next;
        
    }
}
