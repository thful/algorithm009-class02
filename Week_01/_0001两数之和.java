package 数组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _0001两数之和 {
    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     * <p>
     * 示例:
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     * <p>
     * 链接：https://leetcode-cn.com/problems/two-sum
     */
    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 4, 9, 1, 41, 5};
        int target = 9;
        _0001两数之和 res = new _0001两数之和();
        System.out.println(Arrays.toString(res.twoSum1(nums, target)));
        System.out.println(Arrays.toString(res.twoSum2(nums, target)));
    }

    /*
     * 争议较大的HashMap
     * */
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int sum = target - nums[i];
            if (map.containsKey(sum)) {
                return new int[]{map.get(sum), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0, 0};
    }

    /*
     * 算法题中不太想用内置的数据结构
     * */
    public int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }
}
