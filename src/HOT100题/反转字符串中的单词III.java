package HOT100题;

public class 反转字符串中的单词III {
    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
    public static String reverseWords(String s) {
        String res = "";
        String[] ss = s.split(" ");
        for (int i = 0; i < ss.length-1; i++) {
            StringBuilder ab = new StringBuilder(ss[i]);
            res += ab.reverse() + " ";
        }
        StringBuilder ab = new StringBuilder(ss[ss.length-1]);
        res += ab.reverse();
        return res;
    }
}
