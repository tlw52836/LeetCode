package HOT100题;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 建立二叉树
     * @param nums
     * @return
     */
    public static TreeNode build(Integer[] nums) {
        int i = 0;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(nums[i++]);
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode elem = q.poll();

            //建立左结点
            if (i < nums.length && nums[i] != null) {
                TreeNode l = new TreeNode(nums[i++]);
                elem.left = l;
                q.offer(l);
            } else {
                i++;
            }

            //建立右结点
            if (i < nums.length && nums[i] != null) {
                TreeNode r = new TreeNode(nums[i++]);
                elem.right = r;
                q.offer(r);
            } else {
                i++;
            }
        }

        return root;
    }

    /**
     * 二叉树的先序遍历
     * @param root
     */
    public static void preOrder(TreeNode root) {
        if(root == null){
            return;
        } else {
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}
