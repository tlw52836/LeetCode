import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class 二叉树的中序遍历 {
    static List<Integer>   list = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = TreeNode.build(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1});
        inorderTraversal(root);
        System.out.println(list);
    }

    /**
     * 中序递归遍历
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        if(root != null){
            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);
        }
        return list;

    }
}
