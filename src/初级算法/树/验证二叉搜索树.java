package 初级算法.树;

public class 验证二叉搜索树 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.build(new Integer[]{5,1,4,null,null,3,6});
        System.out.println(Integer.MIN_VALUE);
        Solution s = new Solution();
        System.out.println(s.isValidBST(root));
    }
}

class Solution {
    private Integer preNum = null;
    private boolean res = true;



    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        return res;
    }

    /**
     * 树的中序遍历变形
     * @param root
     */
    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            if (preNum != null && preNum >= root.val) {
                res = false;
                //剪枝
                return;
            } else {
                preNum = root.val;
            }
            inOrder(root.right);
        }
    }
}
