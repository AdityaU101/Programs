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
class Merge2BinaryTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null) return null;
        if(root1==null) return root2;
        if(root2==null) return root1;
        TreeNode fin = new TreeNode(root1.val+root2.val);
        fin.right=mergeTrees(root1.right, root2.right);
        fin.left=mergeTrees(root1.left, root2.left);
        return fin;
        
    }
}
