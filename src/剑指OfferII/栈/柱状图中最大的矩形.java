package 剑指OfferII.栈;

import java.util.Stack;

public class 柱状图中最大的矩形 {
    public static void main(String[] args) {
        int[] heights = {5,4,1,2};
        System.out.println(largestRectangleArea(heights));
    }


    public static int largestRectangleArea(int[] heights) {
        int res = 0;
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (s.peek() > -1 && heights[i] < heights[s.peek()]) {
                res = Math.max(res, heights[s.pop()] * (i - s.peek()-1));
            }
            s.push(i);
        }

        while (s.peek() != -1) {
            res = Math.max(res, heights[s.pop()] * (heights.length - s.peek()-1));
        }

        return res;
    }
}
