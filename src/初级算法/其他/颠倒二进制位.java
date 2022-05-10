package 初级算法.其他;

public class 颠倒二进制位 {
    public static void main(String[] args) {
        int num = 3;

    }

    public static int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int t = (n >> i) & 1;
            res = (res << 1) | t;
        }

        return res;
    }

}
