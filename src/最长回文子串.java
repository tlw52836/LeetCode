public class 最长回文子串 {
    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {

        String str = ""; //记录最长回文串
        for(int i = 0;i < s.length();i++){
            int m = i,n = s.length() -1;
            while (m < n) {
                if(s.charAt(m) == s.charAt(n)){
                    m++;
                    n--;
                }else {
                    break;
                }
            }
            if(m >= n && (m-n+1) > str.length()){
                str = s.substring(m,n+1);
            }
        }
        return str;
    }
}
