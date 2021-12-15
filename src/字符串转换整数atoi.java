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

        String res = "";
        
        //添加正负号
        if (ss[i] == '-') {
            res += '-';
            i++;
        }

        if (ss[i] == '+') {
            i++;
        }

        //添加数字
        boolean flag = true;

        while (i < ss.length && Character.isDigit(ss[i])) {
            if (ss[i] == '0' && flag) {
                i++;
            } else {
                flag = false;
                res += ss[i];
                i++;
            }
        }

        if (res.equals("-"))
            return 0;

        String inter;
        if (res.charAt(0) == '-') {
            inter = (Integer.MIN_VALUE + "").substring(1);
        } else {
            inter = Integer.MAX_VALUE + "";
        }

        if (res.length() < inter.length())
            return Integer.valueOf(res);
        else if (inter.length() >)

        for (int j = 0; j < ; j++) {

        }



        return -1;
    }

}
