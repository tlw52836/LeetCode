package 图解算法数据结构.动态规划;

public class 把数字翻译成字符串 {
    public static void main(String[] args) {
        System.out.println(translateNum2(18580));
    }

    /**
     * 动态规划dp[i]表示前i个数字的组合总数
     * dp[i] = {dp[i−1]+dp[i−2], dp[i−1]}（二选一）
     * @param num
     * @return
     */
    public static int translateNum(int num) {
        String s = Integer.toString(num);
        if (s.length() <= 1)
            return 1;

        int[] dp = new int[s.length()];  //表示前i个数字的组合总数
        dp[0] = 1;

        int m = 10 * (s.charAt(0)-'0')+s.charAt(1)-'0';
        if (m > 25 || m < 10) {
            dp[1] = 1;
        } else {
            dp[1] = 2;
        }


        for (int i = 2; i < s.length(); i++) {
            m = 10 * (s.charAt(i-1)-'0')+s.charAt(i)-'0';
            if (m > 25 || m < 10) {
                dp[i] = dp[i-1];
            } else {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }

        return dp[s.length()-1];
    }


    /**
     * 动态规划 空间优化
     * @param num
     * @return
     */
    public static int translateNum2(int num) {
        String s = Integer.toString(num);
        if (s.length() <= 1)
            return 1;

        int a = 1;

        int m = 10 * (s.charAt(0)-'0')+s.charAt(1)-'0';
        int b = 2;
        if (m > 25 || m < 10) {
            b = 1;
        }

        int temp;
        for (int i = 2; i < s.length(); i++) {
            m = 10 * (s.charAt(i-1)-'0')+s.charAt(i)-'0';
            if (m > 25 || m < 10) {
                temp = b;
            } else {
                temp = a + b;
            }
            a = b;
            b = temp;
        }

        return b;
    }
}
