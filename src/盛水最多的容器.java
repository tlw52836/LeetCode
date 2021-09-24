public class 盛水最多的容器 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));

    }
    public static  int maxArea(int[] height) {
        int maxArea = 0;  //记录最大面积

        int i = 0,j = height.length-1;
        int area; //记录当前面积
        int left,right;  //记录两边当前高度
        while (i < j) {
            left = height[i];
            right = height[j];
            area =  Math.max( left,right) * (j-i+1);
            if (maxArea < area) {
                maxArea = area;
            }
            if(left < right && i < j){
                while(height[i] <= left){
                    i++;
                }
            }
            else {
                while (height[j] <= right && i < j) {
                    j--;
                }
            }
        }
        return 0;
    }
}
