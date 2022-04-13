package TOP100题;

import java.util.Locale;

public class 二进制求和 {
    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
    }

//    public static  String addBinary(String a, String b) {
//       int i = a.length()-1;
//       int j = b.length()-1;
//       String res = "";
//        int sum;
//        int flag = 0;
//       while (i >=0 && j >= 0) {
//           sum = a.charAt(i) - '0' + b.charAt(j) - '0' + flag;
//           if (sum < 2) {
//               res = sum + res;
//               flag = 0;
//           } else if (sum == 2){
//               res = "0" + res;
//               flag = 1;
//
//           } else {
//               res = "1" + res;
//               flag = 1;
//           }
//           i--;
//           j--;
//       }
//
//       while (i >= 0) {
//           sum = a.charAt(i) - '0' + flag;
//           if (sum < 2) {
//               res = sum + res;
//               flag = 0;
//           } else {
//               res = "0" + res;
//               flag = 1;
//
//           }
//           i--;
//       }
//
//        while (j >= 0) {
//            sum = b.charAt(j) - '0' + flag;
//            if (sum < 2) {
//                res = sum + res;
//                flag = 0;
//            } else {
//                res = "0" + res;
//                flag = 1;
//
//            }
//            j--;
//        }
//
//        if (flag == 1) {
//            res = "1" + res;
//        }
//
//
//        return res;
//    }

    public static  String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        String res = "";
        int sum;
        int flag = 0;  //进位标志

        /**
         * 短字符串补零
         */
        while (aLen < bLen) {
            a = "0" + a;
            aLen++;
        }

        while (bLen < aLen) {
            b = "0" + b;
            bLen++;
        }

        for (int i = aLen-1; i >= 0; i--) {
            sum = a.charAt(i) - '0' + b.charAt(i) - '0' + flag;
            if (sum >= 2) {
                res = sum % 2 + res;
                flag = 1;
            } else {
                res = sum + res;
                flag = 0;
            }
        }

        if (flag == 1) {
            res = "1" + res;
        }

        return res;
    }
}
