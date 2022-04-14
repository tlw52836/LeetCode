package HOT100题;

public class 检测大写字母 {
    public static void main(String[] args) {

        System.out.println(detectCapitalUse("FlaG"));
    }
    public static boolean detectCapitalUse(String word) {
        int f1 = 0;  //第一个字母是否是大写
        int f2 = 0;  //第一个字母之后是否出现过大写字母
        int f3 = 0;  //第一个字母之后是否出现过小写字母

        char[] ch = word.toCharArray();
        if ('A' <= ch[0] && ch[0] <= 'Z') {
            f1 = 1;
        }

        for (int i = 1; i < ch.length; i++) {
            if ('A' <= ch[i] && ch[i] <= 'Z') {
                f2 = 1;
            }
            if ('a' <= ch[i] && ch[i] <= 'z') {
                f3 = 1;
            }
        }

        if (f1 == 1 && f3 == 0)
            return true;

        if (f1 == 1 && f2 == 0)
            return true;

        if (f1 == 0 && f2 == 0)
            return true;

        return false;
    }
}
