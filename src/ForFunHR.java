import sun.reflect.generics.tree.Tree;

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
}
