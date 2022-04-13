package TOP100题;

public class 二叉树的直径 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.build(new Integer[]{4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2});

        Solution s = new Solution();
        System.out.println(s.diameterOfBinaryTree(root));

    }
    static class Solution {
        private int maxPath = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            dfs(root);
            return maxPath;
        }


        /**
         * 最大深度递归代码变形
         * @param root
         * @return
         */
        public int dfs (TreeNode root) {
            if (root == null) {
                return 0;
            } else {
                int lLen = dfs(root.left);
                int rLen = dfs(root.right);
                if (lLen+rLen > maxPath) {
                    maxPath = lLen + rLen;
                }
                return Math.max(lLen, rLen) + 1;
            }
        }
    }
}

