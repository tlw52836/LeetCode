package TOP100题;

public class 汉明距离 {
    public static void main(String[] args) {
        System.out.println(hammingDistance(3,1));
    }
    public static int hammingDistance(int x, int y) {
        int res = 0;
        while (x != 0 && y != 0) {
            if (x % 2 != y % 2) {
                System.out.println("x%2 and y%2:" + x%2 + " " + y%2);
                res++;
            }
            x = x / 2;
            y = y / 2;
        }

        if(y != 0) {
            x = y;
        }

        while (x != 0) {
            if (x % 2 == 1) {
                System.out.println("x%2 or y%2:" + x%2 + " " + y%2);
                res++;
            }
            x = x/2;
        }
        return res;
    }
}
