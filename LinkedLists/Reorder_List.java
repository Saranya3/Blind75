/*
143. Reorder List
-----------------
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed. 

Example 1:
Input: head = [1,2,3,4]
Output: [1,4,2,3]

Example 2:
Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]

*/

//1
class Solution {
    //Reverse
    ListNode reverse(ListNode head){
        ListNode cur=head,prev=null,tmp=null;
        
        while(cur!=null){
            tmp=cur.next;
            cur.next=prev;
            prev=cur;
            cur=tmp;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        //1. Find middle
        ListNode fast=head,slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        //2. Reverse the second half
        ListNode mid=reverse(slow.next);
        slow.next=null;
        
        //3. Rearrange
        //Link 2 lists
        while(head!=null && mid!=null){
            ListNode tmp1 = head.next;
            ListNode tmp2 = mid.next;
            mid.next = head.next;
            head.next = mid;
            head = tmp1;
            mid = tmp2;
        }
        
    }
}
//2
class Solution {
    ListNode reverse(ListNode head){
        ListNode prev=null,cur=head,tmp=null;
        while(cur!=null){
            tmp=cur.next;
            cur.next=prev;
            prev=cur;
            cur=tmp;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        if(head==null)
            return;
        while(head.next!=null){
            head.next=reverse(head.next);
            head=head.next;
        }
        
    }
}
