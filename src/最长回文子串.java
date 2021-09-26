public class 最长回文子串 {
    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {

        String str = s.charAt(0) + ""; //记录最长回文串
        char ch;  //记录当前字符

        int i = 0,j;
        while (i < s.length()) {
            j = s.length()-1;
            ch = s.charAt(i);
            while(i < j && s.charAt(j) != s.charAt(i)){
                j--;
            }
            if (i < j && str.length() < (j-i+1)) {
                str = s.substring(i,j+1);
            }
            i++;
        }
        return str;
    }
}
