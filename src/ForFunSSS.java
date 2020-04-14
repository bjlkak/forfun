import java.util.*;
import java.util.stream.Collectors;

public class ForFunSSS {

    public ForFunSSS() {};

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        boolean buy = true;
        //7 1 5 3 6 4
        if(prices.length == 0 || prices.length == 1) return profit;

        int bought = -1;
        for(int i = 0; i < prices.length; i++) {
            if(buy) {
                if(i == prices.length - 1) break;
                if (prices[i] < prices[i + 1]) {
                    bought = prices[i];
                    buy = false;
                }
            }
            else {
                if(i == prices.length - 1) {
                    profit = profit + prices[i] - bought;
                    break;
                }
                if (prices[i] > prices[i + 1]) {
                    profit = profit + prices[i] - bought;
                    buy = true;
                }
            }
        }

        return profit;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = new String(c);

            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s);
        }

        return map.values().stream().collect(Collectors.toList());
    }

    public int countElements(int[] arr) {
        Set<Integer> set = new HashSet<>();

        Arrays.stream(arr).forEach(c -> set.add(c));

        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            if(set.contains(arr[i]+1)) count++;
        }
        return count;
    }

    public ListNode middleNode(ListNode head) {
        if(head == null) return null;

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null) {
            if(slow.next != null) slow = slow.next;
            if(fast.next != null) fast = fast.next;
            if(fast.next != null) fast = fast.next;
        }

        return slow;
    }

    public boolean backspaceCompare(String S, String T) {
        if(S == null || T == null) return false;
        if(S.equals(T)) return true;

        int count = 0;
        String s = "";
        for(int i = S.length() - 1; i >= 0; i--) {
            if(S.charAt(i) == '#') count++;
            else {
                if(count == 0) s =  S.charAt(i) + s;
                else count--;
            }
        }

        count = 0;
        String t = "";
        for(int i = T.length() - 1; i >= 0; i--) {
            if(T.charAt(i) == '#') count++;
            else {
                if(count == 0) t =  T.charAt(i) + t;
                else count--;
            }
        }

        return s.equals(t);
    }

    Integer max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getLength(root);
        return max;
    }

    private int getLength(TreeNode root) {
        if(root == null) return 0;

        int l = getLength(root.left);
        int r = getLength(root.right);

        max = Math.max(l+r, max);

        return Math.max(l,r) + 1;
    }
}
