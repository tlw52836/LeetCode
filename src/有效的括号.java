import java.util.ArrayList;
import java.util.List;

public class 有效的括号 {
    public static void main(String[] args) {
        String s = ")";
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s) {
        List<String> list = new ArrayList<>();
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                list.add(s.charAt(i)+"");
            }
            else{
                if(list.size() == 0)
                    return false;
                String str = list.remove(list.size()-1);
                if(str.equals("(")){
                    if(s.charAt(i) != ')'){
                        return false;
                    }
                }else if(str.equals("{")){
                    if(s.charAt(i) != '}'){
                        return false;
                    }
                }else{
                    if(s.charAt(i) != ']'){
                        return false;
                    }
                }

            }
//            System.out.println("i:" + i);
//            System.out.println(list);
        }
        if(list.size() != 0)
            return false;
        return true;
    }
}
