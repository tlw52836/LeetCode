package 图解算法数据结构.搜索回溯;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class 从上到下打印二叉树III {
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
        List<TreeNode> q = new ArrayList<>();

        if (root == null)
            return res;

        q.add(root);

        int flag = 0;
        while (!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int len = q.size();

            if (flag % 2 == 0) {
                for (int i = 0; i < q.size(); i++) {
                    list.add(q.get(i).val);
                }
            } else {
                for (int i = q.size()-1; i >= 0; i--) {
                    list.add(q.get(i).val);
                }
            }

            res.add(list);


            for (int i = 0; i < len; i++) {
                TreeNode e = q.remove(0);
                list.add(e.val);
                TreeNode l = e.left;
                TreeNode r = e.right;
                if (l != null)
                    q.add(l);

                if (r != null)
                    q.add(r);
            }

            flag++;
        }
        return res;
    }
}