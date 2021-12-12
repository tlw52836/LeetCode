public class 二的幂 {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1073741825));
    }

    public static boolean isPowerOfTwo(int n) {
        for (int i = 0; i < 32; i++) {
            double num =  Math.pow(2, i);
            if (num == n)
                return true;

            if (num > n)
                return false;
        }
        return false;
    }
}
