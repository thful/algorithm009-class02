package 二叉树;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * 公司：字节跳动、亚马逊、微软在半年内面试中考过
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 */
public class _0102二叉树的层序遍历 {

    /**
     * 解题思路：
     * 此题只要明白一个点：当前循环队列的长度就是当前层的长度即可
     * */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 定义返回值
        List<List<Integer>> result = new ArrayList<>();
        // 判断参数
        if (root == null) return result;

        // 定义队列并把首节点入队
        Queue<TreeNode> item = new LinkedList();
        item.offer(root);
        // 循环队列
        while (!item.isEmpty()) {
            // 当前队列的长度就是当前层的长度
            int size = item.size();
            // 定义每层的数组
            List<Integer> subres = new ArrayList<>();
            // 循环当前层
            for (int i = 0; i < size; i++) {
                // 依次取出元素并添加的当前层结果中
                TreeNode curee = item.poll();
                subres.add(curee.val);
                if (curee.left != null) {
                    item.offer(curee.left);
                }
                if (curee.right != null) {
                    item.offer(curee.right);
                }
            }
            result.add(subres);
        }
        return result;
    }
}
