public class 回文子串 {
    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(countSubstrings(s));
    }

    public static int countSubstrings(String s) {
        int count = s.length();
        int l, r;
        for (int i = 0;i < s.length();i++) {
            l = i - 1;
            r = i + 1;

            while (l >= 0 && s.charAt(l) == s.charAt(i)) {
                count++;
                l--;
            }

            while (r <= s.length()-1 && s.charAt(r) == s.charAt(i)) {
                count++;
                r++;
            }

            while (l >= 0 && r <= s.length()-1 && s.charAt(l) == s.charAt(r)) {
                count++;
                l--;
                r++;
            }
        }

        return count;
    }
}
