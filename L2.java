//TC:O(max(m,n))
//SC:O(max(m,n))

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1; 
        ListNode c2 = l2;
        ListNode head = new ListNode(0); //use a dummy head to simplify the code
        ListNode cur = head;
        
        int sum = 0;
        while(c1 != null || c2 != null){
            sum /= 10;
            if(c1 != null){
                sum += c1.val;
                c1 = c1.next;
            }
            
            if(c2 != null){
                sum += c2.val;
                c2 = c2.next;
            }
            
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }
        // like 99 + 1 = 100 we need to set 1 for next digit
        if(sum / 10 == 1){
            cur.next = new ListNode(1);
        }
        
        return head.next;
    }
}