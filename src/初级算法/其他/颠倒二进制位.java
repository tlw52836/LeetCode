package 初级算法.其他;

public class 颠倒二进制位 {
    public static void main(String[] args) {
        System.out.println(Integer.valueOf("10000001011010111110000101100011",2));
        //System.out.println(reverseBits(43261596));
    }

    public static int reverseBits(int n) {
        String s = "";
        for (int i = 0; i < 32; i++) {
            if((n & 1 << i) != 0) {
                s = "0" + s;
            } else {
                s = "1" + s;
            }
        }
        System.out.println(s);
        Integer res = Integer.valueOf(s, 2);
        return res;
    }

}
