package HOT100题.动态规划;

public class 不同的二叉搜索树 {
    public static void main(String[] args) {
        System.out.println(numTrees(19));
    }

    /**
     * G(n)为n个节点存在二叉排序树的个数
     * 则G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)
     *
     *
     * 解题思路：假设n个节点存在二叉排序树的个数是G(n)，1为根节点，2为根节点，...，n为根节点
     * 当1为根节点时，其左子树节点个数为0，右子树节点个数为n-1，同理当2为根节点时，其左子树节点个数为1，右子树节点为n-2
     * 所以可得G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)
     * @param n
     * @return
     */


    public static int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += (dp[j] * dp[i-1-j]);
            }
        }
        return dp[n];
    }
}
