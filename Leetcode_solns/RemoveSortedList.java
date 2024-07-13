public class RemoveSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while(temp!=null && temp.next!=null){
            if(temp.val==temp.next.val){
                temp.next=temp.next.next;
            }
            else{temp=(ListNode) temp.next;}
            
        }
        return head;
    }
}
