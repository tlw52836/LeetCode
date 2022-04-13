package TOP100题;

public class 整数替换 {
    public static void main(String[] args) {
        System.out.println(integerReplacement(7));
    }
    public static int integerReplacement(int n) {
        int count = 0;
        while (n != 1) {
            if (n % 2 == 0){
                n  = n / 2;
                count++;
            }
            else {
                Integer a = n - 1;
                Integer b = n + 1;
                if ((a & (a-1)) == 0)
                    n -= 1;
                else if ((b & (b-1)) == 0)
                    n += 1;
                else
                    n -= 1;
                count++;
            }
        }
        return count;
    }
}
