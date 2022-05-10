package 初级算法.树;

public class 二叉树的最大深度 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.build(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(maxDepth(root));
    }
    public static int maxDepth (TreeNode root){
        if (root != null) {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }

        return 0;
    }
}
