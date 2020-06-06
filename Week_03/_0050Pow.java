package 递归;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 * <p>
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * <p>
 * 链接：https://leetcode-cn.com/problems/powx-n
 */
public class _0050Pow {
    public static void main(String[] args) {
        System.out.println(myPow2(2.00000, 10));
    }

    // 递归法
    public static double myPow2(double x, int n) {
        if (n < 0) {
            return 1.0 / p(x, -n);
        } else {
            return p(x, n);
        }
    }

    public static double p(double x, int n) {
        // 终止条件
        if (n == 0) return 1.0;
        // 二分递归 分治思想
        double res = p(x, n / 2);
        return n % 2 == 0 ? res * res : res * res * x;
    }

    // 暴力法
    public static double myPow(double x, int n) {
        if (n == 0) return x;
        double result = 1.0;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        for (int i = 0; i < n; i++) {
            result *= x;
        }
        return result;
    }
}
