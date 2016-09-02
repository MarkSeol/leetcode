import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given nums = [2, 7, 11, 15], target = 9, 
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 * 
 * @author Markxue 
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = { 0, 0 };
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result[0] = i;
                result[1] = map.get(nums[i]);
                break;
            } else {
                map.put(target - nums[i], i);
            }
        }
        Arrays.sort(result);
        return result;
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = { 3, 2, 4 };
        int[] result = s.twoSum(nums, 6);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
