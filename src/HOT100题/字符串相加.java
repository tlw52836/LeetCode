package HOT100题;

public class 字符串相加 {
    public static void main(String[] args) {
        System.out.println(addStrings("456", "77"));
    }

    public static String addStrings(String num1, String num2) {
        while (num1.length() < num2.length()) {
            num1 = "0" + num1;
        }

        while (num2.length() < num1.length()) {
            num2 = "0" + num2;
        }

        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();


        String  res = "";
        int add, flag = 0;  //flag为进位标志
        for (int i = n1.length-1; i >= 0; i--) {
            add =  n1[i] - '0' + n2[i] - '0' + flag;
            flag = add / 10;
            res = add % 10 + res;
        }

        if (flag > 0) {
            res = flag + res;
        }

        return res;
    }
}
