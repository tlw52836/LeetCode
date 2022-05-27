package OJ练习;

import java.util.Arrays;
import java.util.Scanner;

public class 字符串排序1 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) {
            ss[i] = in.next();
        }
        Arrays.sort(ss);
        for (int i = 0; i < n; i++) {
            System.out.print(ss[i] + " ");
        }
    }
}
