package 二叉树;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 * <p>
 * 示例:
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 公司：谷歌、微软、字节跳动在半年内面试中考过
 * <p>
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 */
public class _0144二叉树的前序遍历 {
    public static void main(String[] args) {

    }

    /**
     * 解题思路：
     * 1.走递归 使用一个数组存储节点值
     * 2.先把根节点加入数组 然后递归左子树与右子树 即进行前序遍历
     *
     * 时间复杂度：O(n) 每个节点都要访问一次
     * 空间复杂度：O(n) 有可能此二叉树的高度 和 节点的数量 一致
     * */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        // 前序遍历 = 根 左 右
        preorderTraversal(root, list);
        return list;
    }

    public void preorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        // 根
        list.add(root.val);
        // 左
        preorderTraversal(root.left, list);
        // 右
        preorderTraversal(root.right, list);
    }
}
