/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * 示例:
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * <p>
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 */
public class _0042接雨水 {
    public int trap(int[] height) {
        if (height.length == 0) return 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int result = 0;
        while (left <= right) {
            if (leftMax < rightMax) {
                result += leftMax - height[left] > 0 ? leftMax - height[left] : 0;
                leftMax = Math.max(leftMax, height[left]);
                left++;
            } else {
                result += rightMax - height[right] > 0 ? rightMax - height[right] : 0;
                rightMax = Math.max(rightMax, height[right]);
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new _0042接雨水().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
