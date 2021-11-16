import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class 最长回文串 {
    public static void main(String[] args) {
        System.out.println((int)'a');
        System.out.println((int)'A');
        System.out.println(longestPalindrome("cccsdfsxc"));
    }

//    public static int longestPalindrome(String s) {
//
//        Map<Character, Integer> maps = new HashMap<>();
//        char[] ss = s.toCharArray();
//        for (int i = 0; i < ss.length; i++) {
//            maps.put(ss[i], maps.getOrDefault(ss[i],0)+1);
//        }
//
//        int count = 0;
//        int flag = 0;
//
//        for (int m:maps.values()) {
//            if (m % 2 == 0) {
//                count += m;
//            } else {
//                count += (m-1);
//                flag = 1;
//            }
//        }
//
//        if (flag == 1) {
//            count++;
//        }
//
//        return count;
//    }


    public static int longestPalindrome(String s) {

        int[] a = new int[58];
        char[] ss = s.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            a[ss[i]-'A']++;
        }

        int count = 0;
        int flag = 0;

        for (int m:a) {
            if (m % 2 == 0) {
                count += m;
            } else {
                count += (m-1);
                flag = 1;
            }
        }

        if (flag == 1) {
            count++;
        }

        return count;
    }
}
