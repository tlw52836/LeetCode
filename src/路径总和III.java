public class 路径总和III {
    public static void main(String[] args) {
        TreeNode root = TreeNode.build(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1});
        Solution s = new Solution();
        System.out.println(s.dfs(root));
    }
    static class Solution {
        public int pathSum(TreeNode root, int targetSum) {

            return -1;
        }

        public int dfs(TreeNode root) {
            if (root == null)
                return 0;

            int l = dfs(root.left);
            int r = dfs(root.right);

            return Math.max(l,  r) + root.val;

        }
    }


}
