
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ForFunHR {

    public static void main(String[] args) {
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.left = new TreeNode(3);
        t.right.right = new TreeNode(1);
        System.out.println(rob(t));
    }

    private static int monotoneIncreasingDigits(int n) {
        char[] nums = String.valueOf(n).toCharArray();

        boolean nines = false;
        for(int i = 0; i < nums.length; i++) {
            if(nines) {
                nums[i] = '9';
            }
            else if (i < nums.length -1 && nums[i] > nums[i+1]) {
                nines = true;
                char t =(char)(nums[i] - 1);

                if(i > 0 && t < nums[i-1]) {
                    nums[i] = '9';
                    nums[i-1] = (char)(nums[i-1] - 1);

                    for (int j = i - 1; j > 0 ; j--) {
                        if(nums[j] < nums[j-1]) {
                            nums[j] = '9';
                            nums[j-1] = (char)(nums[j-1] - 1);
                        }
                    }
                }
                else {
                    nums[i] = t;
                }
            }
        }

        return Integer.parseInt(new String(nums));
    }

 public static class TreeNode {
   int val;
   TreeNode left;
  TreeNode right;
   TreeNode(int x) { val = x; }
 }

    private static  int rob(TreeNode root) {
        int[] result = robR(root);
        return Math.max(result[0], result[1]);
    }

    private static int[] robR(TreeNode root){
        int[] result = new int[2];

        if(root == null){
            return result;
        }

        int[] lefts = robR(root.left);
        int[] rights = robR(root.right);
        result[0] = lefts[1] + rights[1]+ root.val;
        result[1] = Math.max(lefts[1], lefts[0]) + Math.max(rights[0], rights[1]);

        return result;
    }

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
