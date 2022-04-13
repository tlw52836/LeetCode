package TOP100题;

public class 判断子序列 {
    public static void main(String[] args) {
        System.out.println(isSubsequence("aaaaaa", "bbaaaa"));
    }

    /**
     * 将s中的字符逐一与t中的字符作比较
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence(String s, String t) {
        if (s.length() != 0 && t.length() == 0)
            return false;

        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int j = 0;

        for (int i = 0; i < ss.length; i++) {
            while (ss[i] != tt[j]) {
                j++;
                if (j >= tt.length)
                    return false;
            }
            j++;
            if (i < ss.length-1 && j >= tt.length)
                return false;
        }
        return true;
    }
}
