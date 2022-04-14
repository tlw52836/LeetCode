package 初级算法.字符串;

import java.util.Arrays;

public class 反转字符串 {
    public static void main(String[] args) {
        char[] s = {'a', 'b', 'g'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public static void reverseString(char[] s) {
        int i = 0, j = s.length-1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}
