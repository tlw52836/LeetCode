public class deleteTheSame {
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int count = removeDuplicates(nums);
        System.out.println("删除后个数：" + count);
        for(int m = 0;m < count;m++){
            System.out.print(nums[m] + " ");
        }
    }
    public static int removeDuplicates(int[] nums) {
        int i = 0,j = 1;
        int t = 1; //用于计数,nums[0]默认记录
        while(j < nums.length){
            if(nums[i] != nums[j]){
                nums[t++] = nums[j];
                i = j;
            }
            j ++;
        }
        return t;
    }
}
