package 初级算法.字符串;

public class 最长公共前缀 {
    public static void main(String[] args) {
        String[] strs = {"aaa","aa","aaa"};
        System.out.println(longestCommonPrefix(strs));
    }

    /**
     * 将每个字符串与公共前缀进行比较，更新公共前缀
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 1)
            return strs[0];

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            prefix = twoLongestCommonPrefix(prefix, strs[i]);
        }

        return prefix;
    }


    public static String twoLongestCommonPrefix (String s1, String s2) {
        int i;
        for (i = 0;i < s1.length() && i < s2.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                break;
        }
        return s1.substring(0,i);
    }
}


