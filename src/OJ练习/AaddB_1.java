package OJ练习;

import java.util.Scanner;

public class AaddB_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int a = in.nextInt();
            int b = in.nextInt();
            if (a == 0 && b == 0)
                break;
            System.out.println(a + b);
        }
        in.close();
    }
}
