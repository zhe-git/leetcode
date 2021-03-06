//Recursion
//TC:O(m+n)
//SC:O(m+n)
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        if(l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else{
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    } 
}


//Iteration
//TC:O(m+n)
//SC:O(1)
class Solution {
   public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode pre = head;
        
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                pre.next = l1;
                l1 = l1.next;
            }
            else{
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        
        return head.next;
    } 
}