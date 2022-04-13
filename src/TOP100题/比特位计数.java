package TOP100题;

import java.util.Arrays;

public class 比特位计数 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
    }

    /**
     * 奇数：二进制表示中，奇数一定比前面那个偶数多一个 1，因为多的就是最低位的 1
     *偶数：二进制表示中，偶数中 1 的个数一定和除以 2 之后的那个数一样多。因为最低位是 0，除以 2 就是右移一位，也就是把那个 0 抹掉而已，所以 1 的个数是不变的
     * @param n
     * @return
     */
    public static int[] countBits(int n) {
        int[] res = new int[n+1];
        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) {
                res[i] = res[i/2];
             } else{
                res[i] = res[i-1]+1;
            }
        }
        return res;
    }
}
