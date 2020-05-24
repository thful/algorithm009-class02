package 数组;

import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 公司：
 * 谷歌、字节跳动、Facebook 在半年内面试中考过
 * <p>
 * 链接：https://leetcode-cn.com/problems/plus-one
 */
public class _0066加一 {

    public static void main(String[] args) {
        _0066加一 run = new _0066加一();
        System.out.println(Arrays.toString(run.plusOne(new int[]{4, 9, 2, 9})));
        System.out.println(Arrays.toString(run.plusOne(new int[]{9, 9, 9, 9})));
    }

    /**
     * 题目限制：
     * 单个数字，最大为9，最小为1
     * <p>
     * 解题思路：
     * 1.从数组最后一位开始循环
     * 2.如果不是9 直接+1后返回
     * 3.如果是9 就赋值0 由下次循环中它的前驱+1返回
     * 4.如果全是9 就全部赋值0 最后把数组长度+1 arr[0]=1即可
     */
    public int[] plusOne(int[] arrs) {
        int index = arrs.length - 1;
        while (index >= 0) {
            if (arrs[index] != 9) {
                arrs[index]++;
                return arrs;
            } else {
                arrs[index] = 0;
            }
            index--;
        }
        arrs = new int[arrs.length + 1];
        arrs[0] = 1;
        return arrs;
    }
}
