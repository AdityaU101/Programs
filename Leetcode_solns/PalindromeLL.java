public class PalindromeLL {
    public boolean isPalindrome(ListNode head) {
        if(head==null) return false;
        
    }
    public ListNode reverseLL(ListNode root){
        ListNode prev=null;
        while(root!=null){
            ListNode temp= root.next;
            root.next=prev;
            prev=root;
            root=temp;
        }
        return prev;
    }
}
