package 图解算法数据结构.搜索回溯;


import java.util.*;

class 从上到下打印二叉树I {
    public static void main(String[] args) {
        TreeNode root = TreeNode.build(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println(Arrays.toString(levelOrder(root)));
    }
    public static int[] levelOrder(TreeNode root) {
        List<Integer> listRes = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode elem = queue.poll();
            listRes.add(elem.val);

            if (elem.left != null) {
                queue.offer(elem.left);
            }

            if (elem.right != null) {
                queue.offer(elem.right);
            }
        }
        int[] intRes = new int[listRes.size()];
        for (int i = 0; i < listRes.size(); i++) {
            intRes[i] = listRes.get(i);
        }
        return intRes;
    }
}