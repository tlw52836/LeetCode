package HOT100题;

public class 重复的子字符串 {
    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("aba"));
    }

    public static boolean repeatedSubstringPattern(String s) {

        char[] ss = s.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            for (int j = i+1; j <= ss.length / 2; j++) {
                if (ss.length % (j-i) != 0)
                    continue;

                int t = 0;
                int k = i;

                while (t < ss.length) {
                    if (ss[i] != ss[t]) {
                        break;
                    } else {
                        k = k+1 >= j ? 0 : k+1;
                        t++;
                    }
                }
                return true;
            }
        }

        return false;
    }
}
