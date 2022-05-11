package 图解算法数据结构.搜索回溯;


import java.util.*;

class 从上到下打印二叉树II {
    public static void main(String[] args) {
        TreeNode root = TreeNode.build(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println(levelOrder(root));
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