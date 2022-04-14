package HOT100题;

public class 实现strStr {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";

        Solution s = new Solution();

        System.out.println(s.strStr(haystack, needle));
    }

    static class Solution {
        public int strStr(String haystack, String needle) {
            if (needle.length() == 0){
                return 0;
            }

            for (int i = 0; i < haystack.length(); i++) {
                if (i + needle.length() >= haystack.length()){
                    break;
                }

                if (haystack.substring(i, i+needle.length()).equals(needle)) {
                    return i;
                }
            }

            return -1;
        }
    }
}
