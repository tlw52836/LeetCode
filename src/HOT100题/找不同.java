package HOT100题;

public class 找不同 {
    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        System.out.println(findTheDifference(s, t));
    }

    public static char findTheDifference(String s, String t) {
        int[] count = new int[26]; //用于计数s中各字符的个数
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)-'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            if (count[t.charAt(i)-'a'] == 0) {
                return t.charAt(i);
            } else {
                count[t.charAt(i)-'a']--;
            }
        }
        return '0';
    }
}
