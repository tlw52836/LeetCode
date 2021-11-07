public class 合并二叉树 {
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null || root2 == null){
            return null;
        }

        if (root1 == null) {
            return root2;
        }

        mergeTrees(root1.left, root2.left);
        mergeTrees(root1.right, root2.right);
        return null;
    }

}
