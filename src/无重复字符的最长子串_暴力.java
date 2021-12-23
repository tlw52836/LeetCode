public class 无重复字符的最长子串_暴力 {
    public static void main(String[] args) {
        String s = "bpfbhmipx";
        System.out.println("最长子串长度：" + lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;

        int len = 1; //用于记录无重复字符的最长子串的长度
        String str = s.charAt(0) + "";  //用于记录当前扫描串的不同字符，t为数量
        int t = 1;
        int i = 0,j = 0;
        while(i < s.length()){
            if(j >= s.length())
                break;
            j = i + 1;
           while(j < s.length()){
                if(str.indexOf(s.charAt(j)) == -1){
                    str += s.charAt(j);
                    t++;
                    j++;

                    System.out.println("!=:" + str);
                }
                else{
                    if(t > len){
                        len = t;
                    }
                    System.out.println("==:" + str);
                    i = str.indexOf(s.charAt(j)) + i + 1;
                    if(i < s.length()){
                        str = s.charAt(i) + "";
                        t = 1;
                        System.out.println("i" + i);
                    }

                    break;
                }
               if(t > len)
                   len = t;
            }
        }
        return len;
    }
}
