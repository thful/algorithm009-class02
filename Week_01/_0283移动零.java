package 数组;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>
 * 公司：
 * 华为、字节跳动在近半年内面试常考
 *
 * <p>
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 */
public class _0283移动零 {
    public void moveZeroes(int[] nums) {
        int zeroindex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[zeroindex] = nums[i];
                if (i != zeroindex) {
                    nums[i] = 0;
                }
                zeroindex++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{0, 1, 0, 0, 9, 2, 3};
        int[] arr2 = new int[]{1};
        new _0283移动零().moveZeroes(arr1);
        new _0283移动零().moveZeroes(arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
