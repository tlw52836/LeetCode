package TOP100题;

import java.util.Arrays;

public class 密钥格式化 {
    public static void main(String[] args) {

        System.out.println(licenseKeyFormatting("2-5g-3-J", 2));
    }

//    public static String licenseKeyFormatting(String s, int k) {
//        s = s.toUpperCase();
//        String[] ss = s.split("-");
//        String str = "";
//        for (int i = 0; i < ss.length; i++) {
//            str += ss[i];
//        }
//
//        String res = "";
//        int j = str.length();
//        while (j >= k) {
//            res = "-" + str.substring(j-k, j) + res;
//            j -= k;
//        }
//
//        if (j != 0) {
//            res = str.substring(0,j) + res;
//        } else if(res.length() > 0){
//            res = res.substring(1,res.length());
//        }
//
//        return res;
//    }

    public static String licenseKeyFormatting(String s, int k) {
       StringBuilder ss = new StringBuilder(s);
        for (int i = 0; i < ss.length();) {
            if (ss.charAt(i) == '-')
                ss.deleteCharAt(i);
            else
                i++;
        }
        System.out.println(ss);


        for (int i = ss.length() - k;i > 0;i -= k) {
            ss.insert(i,'-');
        }

        return ss.toString().toUpperCase();
    }
}
