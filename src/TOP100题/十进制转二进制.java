package TOP100题;

public class 十进制转二进制 {
    public static void main(String[] args) {
        System.out.println(transform(42));
    }

    /**
     * 正整数转换为二进制
     * @param num
     * @return
     */
    public static String transform(int num){
        String s = "";
        while (num != 0) {
            s = (num % 2) + s;
            num = num / 2;
        }
        return s;
    }
}
