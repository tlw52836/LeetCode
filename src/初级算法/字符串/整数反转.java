package 初级算法.字符串;

import java.math.BigInteger;
import java.util.Arrays;

public class 整数反转 {
    public static void main(String[] args) {
        System.out.println(reverse3(123));
    }


    /**
     * 利用long存储结果
     * @param x
     * @return
     */
    public static int reverse(int x) {
        long res = 0;

        while (x != 0) {
            int a = x % 10;
            res = res * 10 + a;
            x = x / 10;
        }

        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
            return 0;


        return (int) res;
    }

    /**
     * 在过程中判断是否超出边界1
     * @param x
     * @return
     */
    public static int reverse2(int x) {
        int res = 0;

        while (x != 0) {
            int a = x % 10;
            int newRes = res * 10 + a;
            //判断是否超出边界
            if ((newRes-a) / 10 != res)
                return 0;
            res = newRes;
            x = x / 10;
        }
        return res;
    }

    /**
     * 在过程中判断是否超出边界2
     * @param x
     * @return
     */
    public static int reverse3(int x) {
        int res = 0;

        while (x != 0) {
            int a = x % 10;
            //判断是否超出边界
            if ((res > Integer.MAX_VALUE/10 || res == Integer.MAX_VALUE/10 && a > Integer.MAX_VALUE % 10) || (res < Integer.MIN_VALUE/10 || res == Integer.MIN_VALUE/10 && x < Integer.MIN_VALUE%10))
                return 0;
            res = res * 10 + a;
            x = x / 10;
        }
        return res;
    }
}
