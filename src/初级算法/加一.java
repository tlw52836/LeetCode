package 初级算法;

import sun.applet.AppletEventMulticaster;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 加一 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(Arrays.toString(plusOne(nums)));
    }
    public static int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList<>();
        int carry = 0;
        int sum;

        for (int i = digits.length-1; i >= 0; i--) {
            sum = digits[i] + carry;
            if (i == digits.length-1)
                sum += 1;
            if (sum <= 9) {
                list.add(sum);
                carry = 0;
            } else {
                list.add(sum % 10);
                carry = 1;
            }
        }
        if (carry == 1) {
            list.add(1);
        }

        //列表转为数组
        int[]  res = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            res[list.size()-k-1] = list.get(k);
        }
        return res;
    }
}
