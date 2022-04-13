package TOP100题;

public class 翻转二叉树2 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.build(new Integer[]{4,2,7,1,3,6,9});
        invertTree(root);
        TreeNode.preOrder(root);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);

        //交换
        root.left = right;
        root.right = left;

        return root;
    }
}
