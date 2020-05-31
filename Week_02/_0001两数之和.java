package 哈希表;

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
     * 公司：亚马逊、字节跳动、谷歌、Facebook、苹果、微软、腾讯在半年内面试中常考
     * 链接：https://leetcode-cn.com/problems/two-sum
     */
    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 4, 9, 1, 41, 5};
        int target = 9;
        _0001两数之和 res = new _0001两数之和();
        System.out.println(Arrays.toString(res.twoSum11(nums, target)));
        System.out.println(Arrays.toString(res.twoSum22(nums, target)));
    }

    /**
     * 暴力解法
     * 思路:
     * 1.两重循环 两个指针 是否等于 index0 = target - index1
     * 2.如果等于就返回index0 index1下标
     * 3.如果循环结束都没有 就返回-1 -1代表没找到
     * <p>
     * 时间:O(n^2) 空间:O(1)
     */
    public int[] twoSum11(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == target - nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }


    /**
     * hash解法
     * 思路：
     * 1.每次循环中得到target - nums[i] = 尝试值res
     * 2.然后去hashmap中找到是否已经存在此值 如果存在就代表map中已经存在值 + nums[i] = target 返回即可
     * 3.如果在map中不存在 就把当前数组下标与数组元素存入hashmap中 hashmap是只可添加非重复项的
     * <p>
     * 时间:O(n) 空间:O(n)
     */
    public int[] twoSum22(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int res = target - nums[i];
            if (map.containsKey(res)) {
                return new int[]{map.get(res), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
