package TOP100题;

import java.math.BigInteger;

public class 字符串转换整数atoi {
    public static void main(String[] args) {
        BigInteger num = new BigInteger("42");
        System.out.println(num);
        //System.out.println(myAtoi("20000000000000000000"));
    }

    public static int myAtoi(String s) {
        char[] ss = s.toCharArray();
        //去空格
        int i = 0;
        while (i < ss.length && ss[i] == ' ') {
            i++;
        }

        //检查第一个字符
        if (i >= ss.length || !(ss[i] == '-' || ss[i] == '+' || Character.isDigit(ss[i])))
            return 0;

        //记录正负号
        int symbol = 1;  // 0 负 1 正
        if (ss[i] == '-') {
            i++;
            symbol = 0;
        }

        if (ss[i] == '+') {
            i++;
        }

        //添加数字
        String digit = "";
        boolean flag = true;

        while (i < ss.length && Character.isDigit(ss[i])) {
            if (ss[i] == '0' && flag) {
                i++;
            } else {
                flag = false;
                digit += ss[i];
                i++;
            }
        }

        if (digit.length() <= 0)
            return 0;

        String inter;

        if (symbol == 0) {
            inter = (Integer.MIN_VALUE + "").substring(1);
        } else {
            inter = Integer.MAX_VALUE + "";
        }

        if (digit.length() < inter.length())
            return Integer.valueOf(digit);
        else if (inter.length() > inter.length())
            return 0;
        else {
            boolean f = true;
            for (int j = 0; j < digit.length(); j++) {
                if (digit.charAt(j) > inter.charAt(j)) {

                }

            }
        }





        return -1;
    }

}
