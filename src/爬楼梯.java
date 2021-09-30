public class 爬楼梯 {
    public static void main(String[] args) {
        System.out.println(climbStairs(1));
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(5));
        System.out.println(climbStairs(6));
    }

    /**
     * n步的走法等于n-1步的走法（再走一步） + n-2步的走法（再走一步）
     * f(n) = f(n-1) + f(n-2)  斐波那切数列
     * 为了减少耗时，下面的函数用循环代替递归实现斐波那切数列
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        int a = 0;
        int b = 1;
        int f = 0;
        for(int i = 1;i <= n;i++){
            f = a + b;
            a = b;
            b = f;
        }
        return f;
    }
}
