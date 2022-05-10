package 初级算法.数学;

import java.util.Arrays;

public class 计算质数 {
    public static void main(String[] args) {
        System.out.println(countPrimes2(1500000));
    }

    /**
     * 方法一：挨个遍历（超时）
     * @param n
     * @return
     */
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

    /**
     * 埃氏筛
     * @param n
     * @return
     */
    public static int countPrimes2(int n) {
        int count = 0;
        boolean[] isPrimes = new boolean[n];  //1~n-1
        Arrays.fill(isPrimes, true);  //初始化所有数为质数，然后筛选出所有合数

        for (int i = 2; i < n; i++) {
            if (isPrimes[i]) {
                count++;
                for (int j = 2*i; j < n; j+=i) {
                    isPrimes[j] = false;
                }
            }
        }
        return count;
    }


}

