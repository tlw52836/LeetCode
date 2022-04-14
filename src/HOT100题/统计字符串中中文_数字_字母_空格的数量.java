package HOT100题;

import java.util.Arrays;

public class 统计字符串中中文_数字_字母_空格的数量 {
    public static void main(String[] args) {
        String s = "222df&& 人";
        System.out.println(Arrays.toString(test(s)));
    }
    public static int[] test(String str1) {
        int[] a = new int[4];
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i)>= '0'&&str1.charAt(i)<='9') {
                a[2]++;
            } else  if (str1.charAt(i) == ' ') {
                a[3]++;
            } else if ((str1.charAt(i) >= 'a' && str1.charAt(i)<='z')||(str1.charAt(i)>='A' && str1.charAt(i)<='Z')) {
                a[1]++;
            } else if((str1.charAt(i)+ "").matches("[\u4e00-\u9fa5]")) {
                a[0]++;
            }
        }
        return a;
    }
}
