package TOP100题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 找到字符串中所有字母异位词_滑动窗口 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p =  "abc";

        List<Integer> res = findAnagrams(s, p);
        System.out.println(res);
    }

    /**
     * 算法复杂度O(m + n)
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        if (sLen < pLen)
            return res;
        /**
         * 利用数组统计字符的个数,并将其初始化
         */
        int[] ss = new int[26];
        int[] pp = new int[26];

        for (int i = 0; i < pLen; i++) {
            pp[p.charAt(i)-97]++;
            ss[s.charAt(i)-97]++;
        }

        if (Arrays.equals(pp, ss))
            res.add(0);

        for (int i = 1; i+pLen-1 < sLen; i++) {
            ss[s.charAt(i-1)-97]--;
            ss[s.charAt(i+pLen-1)-97]++;
            if (Arrays.equals(ss, pp))
                res.add(i);
        }
        return res;
    }

}
