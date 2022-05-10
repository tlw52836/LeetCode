package 初级算法.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的层序遍历 {
    public static void main(String[] args) {
       TreeNode root = TreeNode.build(new Integer[]{1, 2, 3, 4, 5, 6, 7});
       System.out.println(levelOrder(root));
    }

    /**
     * 普通层次遍历
     * @param root
     * @return
     */
    public static List<Integer> ordinaryLevelOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode elem = queue.poll();
            res.add(elem.val);

            if (elem.left != null) {
                queue.offer(elem.left);
            }

            if (elem.right != null) {
                queue.offer(elem.right);
            }
        }
        return res;
    }


    /**
     * 层次遍历 对每一层进行遍历
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if (root == null)
            return res;

        q.offer(root);

        while (!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int len = q.size();
            for (int i = 0; i < len; i++) {
               TreeNode e = q.poll();
                list.add(e.val);
                TreeNode l = e.left;
                TreeNode r = e.right;
                if (l != null)
                    q.offer(l);

                if (r != null)
                    q.offer(r);

            }
            res.add(list);
        }
        return res;
    }
}
