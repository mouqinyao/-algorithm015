class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        TreeNode root = helper(0, preorder.length - 1, preorder, 0, inorder.length - 1, inorder, inMap);
        return root;
    }
    private TreeNode helper(int preStart, int preEnd, int[] preorder, int inStart, int inEnd, int[] inorder, Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);

        // Find root index in inorder traversal
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;
        
        root.left = helper(preStart + 1, preStart + numsLeft, preorder, inStart, inRoot - 1, inorder, inMap);
        root.right = helper(preStart + numsLeft + 1, preEnd, preorder, inRoot + 1, inEnd, inorder, inMap);
        
        return root;
    }
}