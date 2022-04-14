package HOT100题;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的所有路径 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.build(new Integer[]{1, 2, 3, null, 5});

        System.out.println(new Solution().binaryTreePaths(root));
    }
    static class Solution {
        private List<String> list;

        public List<String> binaryTreePaths(TreeNode root) {
            list = new ArrayList<>();
            dfs(root, "");

            return list;
        }

        public void dfs (TreeNode root, String str) {
            if (root.left == null && root.right == null) {
                str += root.val;
                list.add(str);
                return;
            } else {
                str += root.val + "->";
            }

            if (root.left != null)
                dfs(root.left, str);

            if (root.right != null)
                dfs(root.right, str);
        }
    }

}
