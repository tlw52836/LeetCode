package 初级算法.树;

public class 将有序数组转换为二叉搜索树 {
    public static void main(String[] args) {

    }
    public static TreeNode sortedArrayToBST(int[] nums) {
        TreeNode treeNode =  new TreeNode();
        dfs(treeNode, nums, 0, nums.length-1);
        return treeNode;
    }

    public static void dfs(TreeNode treeNode, int[] nums, int left, int right) {
        if (left <= right) {
            int index = (left+right)/2;
            treeNode.val = (nums[index]);

            if (left < index) {
                TreeNode lTreeNode = new TreeNode();
                treeNode.left = lTreeNode;
                dfs(lTreeNode, nums, left, index-1);
            }

            if (right > index) {
                TreeNode rTreeNode = new TreeNode();
                treeNode.right = rTreeNode;
                dfs(rTreeNode, nums, index+1, right);
            }
        }
    }
}
