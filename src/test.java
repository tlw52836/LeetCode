public class test {
    public static void main(String[] args) {
        TreeNode root = TreeNode.build(new Integer[]{1, null, 2, 3});
        System.out.println(root.right.left.val);
        System.out.println(root.right.right);
    }
}
