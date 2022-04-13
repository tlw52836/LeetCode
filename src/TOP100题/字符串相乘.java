package TOP100题;

public class 字符串相乘 {
    public static void main(String[] args) {
        System.out.println("\nresult:" + multiply("123", "456"));
    }

    public static String multiply(String num1, String num2) {
        if (num1.equals("0")|| num2.equals("0"))
            return "0";

        char[] num11 = num1.toCharArray();
        char[] num22 = num2.toCharArray();

        //存放num2中每位数字与num1的相乘结果
        String[] nums = new String[num2.length()];

        int maxLen = -1;  //记录最大长度的字符串
        int flag;  //进位标志
        String str = "";  //暂存结果

        for (int i = num22.length-1; i >= 0; i--) {
            flag = 0;
            str = "";

            for (int j = num11.length-1; j >= 0; j--) {
                int num = (num11[j] - '0') * (num22[i]-'0') + flag;
                flag = num / 10;
                num = num % 10;
                str = num + str;
            }

            //检查进位标志
            if (flag != 0)
                str = flag + str;

            //前补零
            for (int j = 0; j < num22.length-1 - i; j++) {
                str += "0";
            }

            //记录最长串
            if (str.length() > maxLen)
                maxLen = str.length();

            nums[i] = str;
        }


        //后补零
        System.out.print("nums[i]:");
        for (int i = 0; i < nums.length; i++) {
            while (nums[i].length() < maxLen)
                nums[i] = "0" + nums[i];
            System.out.print(nums[i] + " ");
        }

        flag = 0;  //进位标志置0
        str = "";  //暂存结果初始化

        //将nums中的各个数相加
        for (int i = maxLen-1; i >= 0; i--) {
            int num = 0;
            for (int j = 0; j < nums.length; j++) {
                num += nums[j].charAt(i) - '0';
            }
            num += flag;
            flag = num / 10;
            num = num % 10;
            str = num + str;
        }

        if (flag != 0)
            str = flag + str;

        return str;
    }
}

