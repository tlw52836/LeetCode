package TOP100题;

public class 对称二叉树 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.build(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {

        return dfs(root.left, root.right);
    }

    public static boolean dfs(TreeNode root1, TreeNode root2) {

        /**
         * 结点都为null
         */
        if ((root1 == null && root2 == null)) {
            return true;
        }

        /**
         * 一个结点为null
         */
        if (root1 == null || root2 == null ) {
            return false;
        }

        /**
         * 两个值不相等
         */
        if (root1.val != root2.val) {
            return false;
        }

        /**
         * 两个值相等
         */
        boolean res1 = dfs(root1.left, root2.right);
        boolean res2 = dfs(root1.right, root2.left);

        return (res1 && res2);
    }
}
