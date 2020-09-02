/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
      Stack<TreeNode> stack = new Stack<>();
      List<Integer> result = new LinkedList<>();
      if (root == null) return result;
      
      stack.push(root);
      while (!stack.isEmpty()) {
        TreeNode current = stack.pop();
        result.add(current.val);
        if (current.right != null) stack.push(current.right);
        if (current.left != null) stack.push(current.left);
      }
      
      return result;
      // List<Integer> res = new ArrayList<>();
      // helper(root, res);
      //return res;
    }
    // public void helper(TreeNode root, List res) {
      // if (root != null) {
        // res.add(root.val);
        // if (root.left != null) helper(root.left, res);
        // if (root.right != null) helper(root.right, res);
      // }
    // }
}