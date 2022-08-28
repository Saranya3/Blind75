/*
19. Remove Nth Node From End of List
------------------------------------
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:
Input: head = [1], n = 1
Output: []

Example 3:
Input: head = [1,2], n = 1
Output: [1]
*/

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        int len=0;
        ListNode cur=head;
        while(cur!=null){
            len++;
            cur=cur.next;
        }
        
        len-=n;
        cur=dummy;
        while(len>0){
            len--;
            cur=cur.next;
        }
        cur.next=cur.next.next;
        return dummy.next;
    }
}
ListNode start=new ListNode();
        start.next=head;
        ListNode fast=start, slow=start;
        for(int i=0;i<n;i++)
            fast=fast.next;
        
        while(fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next;
        }
        
        slow.next=slow.next.next;
        
        return start.next;
        
