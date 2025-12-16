import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    List<Integer> ans= new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return ans;

    }
    public void dfs(TreeNode root){
        if(root==null) return;

        dfs(root.left);
        ans.add(root.val);
        dfs(root.right);
    }
}
