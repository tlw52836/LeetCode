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

        String res = "";
        if (i < ss.length && ss[i] == '-') {
            res += "-";
            i++;

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

            if (res.length() <= 1)
                return 0;


            BigInteger num = new BigInteger(res);
            BigInteger m = new BigInteger(Integer.MIN_VALUE+"");
            num.compareTo(m);

            return num.compareTo(m) == -1 ? Integer.MIN_VALUE : Integer.valueOf(res);
        } else if (i < ss.length && (ss[i] == '+' || Character.isDigit(ss[i]))) {
            if (ss[i] == '+')
                i++;

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

            if (res.length() <= 0)
                return 0;

            BigInteger num = new BigInteger(res);
            BigInteger m = new BigInteger(Integer.MAX_VALUE+"");
            num.compareTo(m);

            return num.compareTo(m) == 1 ? Integer.MAX_VALUE : Integer.valueOf(res);
        } else {
            return 0;
        }
    }

}
