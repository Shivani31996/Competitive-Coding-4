// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
/*
 * 1 - Find the middle of the LL
 * 2 - Reverse the second LL
 * 3 - Compare and traverse the LL
 */

public class PalindromeLL {
public class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

    public boolean isPalindrome(ListNode head) {
        if(head == null)
            return true;
        
        ListNode slow = head;
        ListNode fast = head.next;
    //to find the middle of the LL    
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode head2 = slow.next;
        slow.next = null;
        
        ListNode prev = null;
        ListNode curr = head2;
        ListNode next;
        
        //to reverse the second LL
        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        head2 = prev;
        
        //check and compare the LL values
        while(head != null && head2 != null)
        {
            if(head.val != head2.val)
                return false;
                
            else
            {
                head = head.next;
                head2 = head2.next;
            }
        }
        return true;
    }
