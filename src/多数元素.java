import java.util.HashMap;
import java.util.Map;

public class 多数元素 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3 ,3};
        System.out.println(majorityElement(nums));
    }

    /**
     * 利用map保存个元素，降低时间复杂度
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        //key:保存元素  value:保存元素个数
        Map<Integer, Integer> maps = new HashMap<>();
        for (int num:nums) {
            if (maps.containsKey(num)) {
                maps.put(num,maps.get(num)+1);
            } else {
                maps.put(num,1);
            }
        }

        //保存个数最多的map
        Map.Entry<Integer,Integer> max = null;
        for (Map.Entry map : maps.entrySet()) {
            if (max == null || (int)map.getValue() > max.getValue()) {
                max = map;
            }
        }
        return max.getKey();
    }
}
