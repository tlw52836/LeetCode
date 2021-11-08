public class 不同路径2 {
    public static void main(String[] args) {
        System.out.println(f(16));
        System.out.println(f(9));
        System.out.println(uniquePaths(10, 10));
    }

    public static int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }

        m--;
        n--;
        return f(m+n) / (f(n) * f(m));
    }

    /**
     * 求n的阶乘
     * @param n
     * @return
     */
    public static int f(int n) {
        if (n == 1) {
            return 1;
        }
        return n * f(n-1);
    }

}
