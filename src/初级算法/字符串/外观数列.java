package 初级算法.字符串;

import java.util.ArrayList;
import java.util.List;

public class 外观数列 {
    public static void main(String[] args) {

        System.out.println(countAndSay(4));
    }

    public static String countAndSay(int n) {
        String s = "1";
        String res = "";
        int t = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) == s.charAt(j-1))
                    t++;
                else {
                    res = res + t + "" + s.charAt(j-1);
                    t = 1;
                }
            }

            //最后一个字符
            res = res + t + "" + s.charAt(s.length()-1);
            s = res;
            res = "";
            t = 1;
        }

        return s;
    }
}
