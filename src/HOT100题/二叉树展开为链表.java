package HOT100题;

import java.util.ArrayList;
import java.util.List;

public class 二叉树展开为链表 {
    public static void main(String[] args) {

    }

    public void flatten(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        dfs(root, res);
        TreeNode p = new TreeNode();
        for (TreeNode re : res) {
            re.left = null;
            p.right = re;
            p = p.right;
        }
    }

    public void dfs(TreeNode root, List<TreeNode> res) {
        if (root != null) {
            res.add(root);
            dfs(root.left, res);
            dfs(root.right, res);
        }
    }
}
