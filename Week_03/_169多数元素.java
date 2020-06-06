package 递归;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _169多数元素 {
    // 用哈希表
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        // 遍历每个数统计次数
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
            // 如果某个数次数超过了n/2就返回
            if (counter.get(num) > nums.length / 2) {
                return num;
            }
        }
        return -1;
    }

    // 暴力
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }

    // 多重变量
    public int majorityElement3(int[] nums) {
        int sum = 0, p = 0;
        for (int x : nums) {
            if (sum == 0) p = x;
            sum = x == p ? sum + 1 : sum - 1;
        }
        return p;
    }
}