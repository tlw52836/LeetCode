package TOP100题;

import com.sun.media.sound.RIFFInvalidDataException;

public class 最长公共前缀 {
    public static void main(String[] args) {
        String[] strs = {"aaa","aa","aaa"};
        Solution s = new Solution();
        System.out.println(s.longestCommonPrefix(strs));
    }
    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            if(strs.length == 1)
                return strs[0];

            String s = strs[0];
            String result = "";  //存放结果
            int flag = 0;  //结束标志
            for (int i = 0; i < s.length() && flag == 0; i++) {
                for (int j = 1; j < strs.length; j++) {
                    if (i >= strs[j].length() || s.charAt(i) != strs[j].charAt(i)) {
                        flag = 1;
                        break;
                    }
                    if (s.charAt(i) == strs[j].charAt(i) && j == strs.length-1) {
                        result += s.charAt(i);
                    }
                }
            }
            return result;
        }
    }
}


