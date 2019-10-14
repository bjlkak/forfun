public class ForFun143 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void reorderList(ListNode head) {
        if(head == null) return;

        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && slow != null) {
            if(fast.next != null) {
                fast = fast.next.next;
            }
            else {
                break;
            }
            slow = slow.next;
        }

        ListNode rev = reverse(slow, null);
        ListNode temp = head;

        while(rev != null && temp != null) {
            ListNode t = temp.next;
            temp.next = rev;
            ListNode r = rev.next;
            rev.next = t;

            temp = t;
            rev = r;

        }

    }

    private ListNode reverse(ListNode head, ListNode parent) { //2 , 1 ->
        ListNode temp = head.next; // null
        head.next = parent; //1->null

        if(temp == null) {
            return head;
        }

        return reverse(temp,head);
    }
}
