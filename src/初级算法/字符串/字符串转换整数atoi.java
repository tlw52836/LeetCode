package 初级算法.字符串;

public class 字符串转换整数atoi {
    public static void main(String[] args) {
        System.out.println("Max:" + Integer.MAX_VALUE);
        System.out.println("Min:" + Integer.MIN_VALUE);
        String s = "-2147483647";
        System.out.println("res:" + myAtoi(s));
    }

    public static int myAtoi2(String s) {
        int res = 0;
        int t = 0;

        //去除空格
        while (t < s.length()) {
            if (s.charAt(t) == ' ')
                t++;
            else
                break;
        }

        //检查正负号
        boolean flag = false;  //是否为负数标志
        if (t < s.length() && s.charAt(t) == '-') {
            flag = true;
            t++;
        } else if (t < s.length() && s.charAt(t) == '+'){
            t++;
        }

        //利用复原进行判定
        while (t < s.length() && Character.isDigit(s.charAt(t))) {
            if (flag) {
                int newRes = 10 * res - (s.charAt(t) - '0');
                if ((newRes+(s.charAt(t) - '0')) % 10 != res)
                    return Integer.MIN_VALUE;
                res = newRes;
            } else {
                int newRes = 10 * res + (s.charAt(t) - '0');
                if ((newRes-(s.charAt(t) - '0')) % 10 != res)
                    return Integer.MAX_VALUE;
                res = newRes;
            }
            t++;
        }

        return res;
    }

    public static int myAtoi(String s) {
        int res = 0;
        int t = 0;

        //去除空格
        while (t < s.length()) {
            if (s.charAt(t) == ' ')
                t++;
            else
                break;
        }

        //检查正负号
        boolean flag = false;  //是否为负数标志
        if (t < s.length() && s.charAt(t) == '-') {
            flag = true;
            t++;
        } else if (t < s.length() && s.charAt(t) == '+'){
            t++;
        }

        //利用边界进行检测
        while (t < s.length() && Character.isDigit(s.charAt(t))) {
            if (flag) {
                int mmm = -s.charAt(t) - '0';
                if (res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE/10 && -(-s.charAt(t)-'0') < Integer.MIN_VALUE%10))
                    return Integer.MIN_VALUE;
                res = 10 * res - (s.charAt(t) - '0');
            } else {
                if (res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && s.charAt(t)-'0' > Integer.MAX_VALUE%10))
                    return Integer.MAX_VALUE;
                res = 10 * res + (s.charAt(t) - '0');
            }
            t++;
        }

        return res;
    }
}
