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
    public List<Integer> inorderTraversal(TreeNode root) {
      Stack<TreeNode> stack = new Stack<>();
      List<Integer> result = new LinkedList<>();
      if (root == null) return result;
      TreeNode current = root;
  
      while (current != null || !stack.isEmpty()) {
        while (current != null) {
          stack.push(current);
          current = current.left;
        }
        current = stack.pop();
        result.add(current.val);
        current = current.right;
      }
      
      return result;
      // List<Integer> res = new ArrayList<>();
      // helper(root, res);
      // return res;
    }
    // public void helper(TreeNode root, List res) {
      // if (root != null) {
        // if (root.left != null) helper(root.left, res);
        // res.add(root.val);
        // if (root.right != null) helper(root.right, res);
      // }
    // }
}