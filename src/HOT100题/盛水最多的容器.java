package HOT100题;

public class 盛水最多的容器 {
    public static void main(String[] args) {
        int[] height = {1,2,1};
        System.out.println(maxArea(height));

    }

    /**
     * 双指针
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int maxArea = 0;  //记录最大面积

        int i = 0,j = height.length-1;
        int area; //记录当前面积
        int left,right;  //记录两边当前高度
        while (i < j) {
            left = height[i];
            right = height[j];
            area =  Math.min( left,right) * (j-i);
            if (maxArea < area) {
                maxArea = area;
            }
            if(left < right){
                i++;
            }
            else {
                j--;
            }
        }
        return maxArea;
    }
}
