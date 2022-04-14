package HOT100题;

public class 最后一个单词的长度 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "   fly me   to   the moon  ";
        System.out.println(s.lengthOfLastWord(str));
    }
    static class Solution {
//        public int lengthOfLastWord(String s) {
//            String[] strings = s.split(" ");
//
//            return strings[strings.length-1].length();
//        }

        public int lengthOfLastWord(String s) {
            int res = 0;
            for (int i = s.length()-1; i >= 0; i--) {
                if (s.charAt(i) != ' ') {
                    res++;
                } else if (res > 0) {
                    return res;
                }
            }
            return res;
        }
    }
}
