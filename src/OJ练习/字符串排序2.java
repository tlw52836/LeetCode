package OJ练习;

import java.util.Arrays;
import java.util.Scanner;

public class 字符串排序2 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String[] ss = in.nextLine().split(" ");
            Arrays.sort(ss);
            for (int i = 0; i < ss.length; i++) {
                System.out.print(ss[i] + " ");
            }
            System.out.println();
        }
        in.close();
    }
}
