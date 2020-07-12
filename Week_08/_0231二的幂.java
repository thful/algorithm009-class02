package 位运算;

/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * <p>
 * 示例 1:
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 * <p>
 * 示例 2:
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 * <p>
 * 示例 3:
 * 输入: 218
 * 输出: false
 * <p>
 * 链接：https://leetcode-cn.com/problems/power-of-two
 */
public class _0231二的幂 {
    // 判断整数是否是 2 的幂次方 必须满足有且仅有一个二进制位是1
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(new _0231二的幂().isPowerOfTwo(1));
        System.out.println(new _0231二的幂().isPowerOfTwo(16));
        System.out.println(new _0231二的幂().isPowerOfTwo(218));
    }
}
