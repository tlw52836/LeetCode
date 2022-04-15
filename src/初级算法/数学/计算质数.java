package 初级算法.数学;

public class 计算质数 {
    public static void main(String[] args) {
        System.out.println(countPrimes(1500000));
    }
    public static int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i))
                count++;
        }
        return count;
    }

    public static boolean isPrime (int num) {
        for (int i = 2; i*i <= num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }


}

