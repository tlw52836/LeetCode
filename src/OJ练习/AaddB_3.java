package OJ练习;
import java.util.Scanner;

public class AaddB_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        while (in.hasNext()) {
            System.out.println(a + b);
            a = in.nextInt();
            b = in.nextInt();

        }

    }
}
