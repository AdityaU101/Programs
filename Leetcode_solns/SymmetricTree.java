
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
 }
}
class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return help(root.left,root.right);
    }
    public boolean help(TreeNode left,TreeNode right){
        if(left==null && right==null) return true;
        if(left==null || right==null || left.val!=right.val) return false;
        return help(left.left,right.right) && help(left.right,right.left);
    }
}