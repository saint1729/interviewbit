/*


https://www.interviewbit.com/problems/insertion-sort-list/



Insertion Sort List
Asked in:  
Microsoft
Google
Sort a linked list using insertion sort.

We have explained Insertion Sort at Slide 7 of Arrays

Insertion Sort Wiki has some details on Insertion Sort as well.

Example :

Input : 1 -> 3 -> 2

Return 1 -> 2 -> 3


*/





/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    
    public void printList(ListNode A) {
        
        ListNode temp = A;
        
        if(temp == null) {
            System.out.println("List is empty");
        }
        
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println("");
        
        return;
    }
    
    public void sortedInsert(ListNode A, int x) {
        
        ListNode B = new ListNode(x);
        
        if((A == null) || (A.val >= B.val)) {
            B.next = A;
            A = B;
        } else {
            ListNode temp = A;
            while((temp.next != null) && (B.val > temp.next.val)) {
                temp = temp.next;
            }
            
            B.next = temp.next;
            temp.next = B;
        }
        
        return;
    }
    
    public ListNode insertionSortList(ListNode A) {
        
        ListNode temp = null;
        
        //printList(A);
        
        while(A != null) {
            sortedInsert(temp, A.val);
            A = A.next;
        }
        
        //printList(temp);
        
        return temp;
    }
}
