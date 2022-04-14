package TOP100题;

public class 翻转二叉树 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.build(new Integer[]{2,3,null,1});
        invertTree(root);
        TreeNode.preOrder(root);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
       dfs(root.left, root.right, root, root, 0);
        return root;
    }

    /**
     *
     * @param root1
     * @param root2
     * @param par1 root1的父节点
     * @param par2 root2的父节点
     * @param flag 标记root1是par1的左子树还是有右子树 0:左子树 1:右子树
     */
    public static void dfs(TreeNode root1, TreeNode root2, TreeNode par1, TreeNode par2, int flag) {
        if (root1 == null && root2 == null) {  //两结点都为空
            return;
        }else if (root1 == null) {  //其中一结点为空
            if (flag == 0) {
                par1.left = root2;
                par2.right = null;
            } else {
                par1.right = root2;
                par2.left = null;
            }
            dfs(root2.left, root2.right, root2, root2, 0);
        } else if (root2 == null) {
            if (flag == 0) {
                par2.right = root1;
                par1.left = null;
            } else {
                par2.left = root1;
                par1.right = null;
            }
            dfs(root1.left, root1.right, root1, root1, 0);
        } else {  //两结点都不为空
            int t = root1.val;
            root1.val = root2.val;
            root2.val = t;
            dfs(root1.left, root2.right, root1, root2, 0);
            dfs(root1.right, root2.left, root1, root2, 1);
        }
    }



    public static TreeNode invertTree2(TreeNode root) {
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
