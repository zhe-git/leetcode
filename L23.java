//TC:O(Nlogk)  every merge costs O(N), we need log2 k times merge
//OC:O(1)

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return helper(lists, 0, lists.length - 1);
    }
    
    //divide lists with 2 parts and repeat it.
    private static ListNode helper(ListNode[] lists, int start, int end){
        if(start == end) return lists[start];
        
        if(start < end){
            int mid = start + (end - start) / 2;
            ListNode l1 = helper(lists, start, mid);
            ListNode l2 = helper(lists, mid + 1, end);
            return merge(l1, l2);
        }
        else{
            return null;
        }
    }
    
    // merge two ListNode
    private static ListNode merge(ListNode l1, ListNode l2){
        ListNode pre = new ListNode(-1);
        ListNode head = pre;
        
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                head.next = l1;
                l1 = l1.next;
            }
            else{
                head.next = l2;
                l2 = l2.next;
                    
            }
            head = head.next;
        }
        
        head.next = l1 == null ? l2 : l1;
        return pre.next;
        
    }
}