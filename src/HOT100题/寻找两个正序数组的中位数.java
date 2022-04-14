package HOT100题;

public class 寻找两个正序数组的中位数 {
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4,5,6,7,8};
        System.out.println(findMedianSortedArrays(nums1,nums2));

    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int mid;
        int sumNums = nums1.length + nums2.length;
        if (sumNums % 2 == 0)
            mid = sumNums / 2 -1;
        else
            mid = sumNums / 2;

        int i = 0,j = 0;
        while (i < nums1.length && j < nums2.length) {
            if(mid == (i+j)){
                if(sumNums % 2 != 0){
                    return Math.min(nums1[i],nums2[j]);
                }else {
                    if(nums1[i] < nums2[j]){
                        if((i+1) < nums1.length)
                            return ((double) nums1[i] + (double) Math.min(nums1[++i],nums2[j]))/2;
                        else{
                            return ((double) nums1[i] + (double) nums2[j])/2;
                        }
                    }else{
                        if((j+1) < nums2.length){
                            return ((double) nums2[j] + (double) Math.min(nums2[++j],nums1[i]))/2;
                        }
                        else
                            return  ((double) nums2[j] + (double) nums1[i])/2;
                    }

                }
            }
            if(nums1[i] < nums2[j])
                i++;
            else
                j++;
        }
        while (i < nums1.length) {
            if(mid == (i+j)){
                if(sumNums % 2 != 0)
                    return nums1[i];
                else
                    return ((double) nums1[i] + (double) nums1[i+1])/2;
            }
            i++;
        }
        while (j < nums2.length) {
            if(mid == (i+j)){
                if(sumNums % 2 != 0)
                    return nums2[j];
                else{
                    System.out.println("tt");
                    return ((double) nums2[j] + (double) nums2[j+1])/2;
                }
            }
            j++;
        }
        return 0;
    }
}
