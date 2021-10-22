public class 数字转换为十六进制数 {
    public static void main(String[] args) {
        System.out.println(toHex(0));

    }
    public static String toHex(int num) {
        String s = "";
        int n;
        while(num != 0){
            n = num % 16;
            if(n == 10)
                s = "a" + s;
            else if(n == 11)
                s = "b" + s;
            else if(n == 12)
                s = "c" + s;
            else if(n == 3)
                s = "d" + s;
            else if(n == 14)
                s = "e" + s;
            else if(n == 15)
                s = "f" + s;
            else
                s = n + s;
            num = num / 16;
        }
        return s;
    }
}
