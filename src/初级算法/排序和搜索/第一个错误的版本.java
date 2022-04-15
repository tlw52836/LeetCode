package 初级算法.排序和搜索;

public class 第一个错误的版本 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }


    //true false false
    public static int firstBadVersion(int n) {
        int l = 1, r = n;
        int mid = 1;
        while (l <= r) {
            mid = l+(r - l) / 2;
            boolean flag = isBadVersion(mid);
            if (flag) {
                r = mid -1;
            } else {
                l = mid + 1;
            }
        }

        if (!isBadVersion(mid)) {
            return mid + 1;
        }
        return mid;
    }

    public static boolean isBadVersion(int version ) {
        return true;
    }
}
