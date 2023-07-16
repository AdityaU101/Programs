
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class revLL {
    public ListNode reverseList(ListNode head) {
        ListNode output = null;
        while(head!=null){
            ListNode temp = head.next;
            head.next=output;
            output=head;
            head=temp;
        }
        return output;
    }
}
