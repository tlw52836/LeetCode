package TOP100题;

import java.util.ArrayList;
import java.util.List;

public class 最小栈 {
    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(-2);
        s.push(0);
        s.push(-3);
        s.pop();
        s.push(-6);
        System.out.println(s.top());
    }


    /**
     * 利用list的add与remove方法进行，push，pop操作，利用minPos记录最小值元素位置
     */

    static class MinStack{

        private List<Integer> s = null;

        //记录最小元素位置
        private int minPos = -1;

        public MinStack() {
           this.s = new ArrayList<>();
        }

        public void push(int val) {
            if (s.size() == 0) {
                minPos = 0;
            } else if (val < s.get(minPos)){
                minPos = s.size();
            }
           s.add(val);
        }

        public void pop() {
            if (s.size()-1 == minPos) {
                if (s.size() <= 1) {
                    minPos = -1;
                } else{
                    minPos = s.size() - 2;
                    for (int i = s.size() - 3; i >= 0; i--) {
                        if (s.get(i) < s.get(minPos)) {
                            minPos = i;
                        }
                    }
                }
            }
            s.remove(s.size()-1);
        }

        public int top() {
            return s.get(s.size()-1);
        }

        public int getMin() {
            return s.get(minPos);
        }
    }
}
