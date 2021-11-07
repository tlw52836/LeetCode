public class 二叉树的最大深度 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.build(new Integer[]{3, 9, 20, null, null, 15, 7});
        Solution s = new Solution();
        System.out.println(s.maxDepth(root));
    }

    static class Solution {
        private int maxDep = 0;
        public int maxDepth(TreeNode root) {
            preOrder(root, 0);

            return maxDep;
        }

        public void preOrder (TreeNode root, int depth) {
            if (root != null) {
                depth++;
            } else {
                if (depth > maxDep) {
                    maxDep = depth;
                }
                return;
            }

            if (root != null && depth > maxDep) {
               maxDep = depth;
            }

            preOrder(root.left, depth);
            preOrder(root.right, depth);
        }
    }
}
