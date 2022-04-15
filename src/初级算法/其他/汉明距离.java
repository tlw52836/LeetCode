package 初级算法.其他;

public class 汉明距离 {
    public static void main(String[] args) {
        System.out.println(hammingDistance(3,1));
    }
    public static int hammingDistance(int x, int y) {
        int res = 0;
        while (x != 0 || y != 0) {
            if (x % 2 != y % 2) {
                res++;
            }
            x = x / 2;
            y = y / 2;
        }

        return res;
    }
}
