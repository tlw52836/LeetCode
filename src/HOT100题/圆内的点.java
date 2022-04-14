package HOT100题;

import java.util.Scanner;

public class 圆内的点 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println();
        int m = input.nextInt();
        int n = input.nextInt();

        int[][] a = new int[m][3];
        for (int i = 0; i < m; i++) {
            a[i][0] = input.nextInt();
            a[i][1] = input.nextInt();
            a[i][2] = input.nextInt();
        }

        int[][] b = new int[n][2];
        for (int i = 0; i < n; i++) {
            b[i][0] = input.nextInt();
            b[i][1] = input.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                int result = (int) (Math.pow((b[j][0]-a[i][0]),2)+Math.pow((b[j][1]-a[i][1]),2));
                if(result <= Math.pow(a[i][2],2))
                    count++;
            }
            System.out.print(count + " ");
        }
    }
}
