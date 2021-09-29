import java.util.ArrayList;
import java.util.List;

public class 二叉树的中序遍历 {
    static List<Integer>   list = new ArrayList<>();

    public static void main(String[] args) {
        Integer[] vec = {1,null,2,3};
        TreeNode root = buildTree(vec,0);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
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


    /**
     * 递归建立二叉树
     * @param vec
     * @param index
     * @return
     */
    public static TreeNode buildTree(Integer[] vec, int index) { //index:当前节点在数组中的下标
        TreeNode root = null;

        if (index < vec.length && vec[index] != null) {
            root = new TreeNode(vec[index]);
            root.left = buildTree(vec, 2 * index + 1);
            root.right = buildTree(vec, 2 * index + 2);
        }
        return root;
    }
}
