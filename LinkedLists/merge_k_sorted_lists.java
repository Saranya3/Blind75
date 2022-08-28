/*
23. Merge k Sorted Lists
-------------------------
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.

Example 1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6

Example 2:
Input: lists = []
Output: []

Example 3:
Input: lists = [[]]
Output: []
 
*/

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
    ListNode merge(ListNode l1,ListNode l2){
        ListNode head=new ListNode(-1,null);
        ListNode dummy=head;
        while(l1!=null||l2!=null){
            if(l1!=null&&l2!=null){
                if(l1.val<=l2.val){
                    head.next=new ListNode(l1.val);
                    l1=l1.next;
                }
                else{
                    head.next=new ListNode(l2.val);
                    l2=l2.next;
                }
            }
            else{
                if(l1!=null){
                    head.next=new ListNode(l1.val);
                    l1=l1.next;
                }
                if(l2!=null){
                    head.next=new ListNode(l2.val);
                    l2=l2.next;
                }
            }
            head=head.next;
        }
        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        ListNode l1=lists[0];
        for(int i=1;i<lists.length;i++){
            l1=merge(l1,lists[i]);
        }
        return l1;
    }
    
}
