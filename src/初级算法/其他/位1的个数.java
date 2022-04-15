package 初级算法.其他;

public class 位1的个数 {
    public static void main(String[] args) {
        System.out.println(hammingWeight(5));
    }
    public static int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1 << i)  != 0)
                res++;
        }
        return res;
    }
}
