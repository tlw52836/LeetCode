package HOT100题;

public class 合并二叉树 {
    public static void main(String[] args) {
        TreeNode root1 = TreeNode.build(new Integer[]{1, 3, 2, 5});
        TreeNode root2 = TreeNode.build(new Integer[]{2, 1, 3, null, 4, null, 7});
        TreeNode root = mergeTrees(root1, root2);
        TreeNode.preOrder(root);
    }

    /**
     * TOP100题.合并二叉树：将root2合并到root1
     * @param root1
     * @param root2
     * @return
     */
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null){
            return root1 == null ? root2 : root1;
        }

        root1.val += root2.val;

        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);

        return root1;
    }



}
