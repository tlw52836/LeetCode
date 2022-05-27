package OJ练习;
import java.util.Scanner;

public class AaddB_6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            int sum = 0;
            String[] ss = s.split(" ");
            for (int i = 0; i < ss.length; i++) {
                sum += Integer.valueOf(ss[i]);
            }
            System.out.println(sum);
        }
        in.close();
    }
}
