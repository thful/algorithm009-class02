package 二叉树;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * <p>
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 公司：亚马逊、微软、字节跳动在半年内面试中考过
 * <p>
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 */
public class _0094二叉树的中序遍历 {
    /**
     * 解题思路：
     * 1.走递归 使用一个数组存储节点值
     * 2.先把左节点进行递归 然后添加节点值加入数组 最后把右节点进行中序递归
     * <p>
     * 时间复杂度：O(n) 每个节点都要访问一次
     * 空间复杂度：O(n) 有可能此二叉树的高度 和 节点的数量 一致
     */
    private List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return list;
        // 中序遍历 ：左-根-右
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }

    /**
     * 解题思路：
     * 1.可以用栈代替递归
     * 2.节点变更指针的思路
     * <p>
     * 时间复杂度：O(n) 每个节点都要访问
     * 空间复杂度：O(n) 二叉树的所有节点
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        // 一开始设置为当前节点
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                // 把当前节点设置为左节点
                curr = curr.left;
            }
            curr = stack.pop();
            // 添加根节点的值
            list.add(curr.val);
            curr = curr.right;
        }
        return list;
    }

    private class ColorNode {
        TreeNode node;
        String color;

        public ColorNode(TreeNode node, String color) {
            this.node = node;
            this.color = color;
        }
    }

    /**
     * 解题思路：颜色标记法
     * 1.使用颜色标记节点的状态 新节点为白色 已访问节点为灰色
     * 2.如果遇到的节点为白色 则将其标记为灰色 然后将右子节点、自身、左子节点依次入栈
     * 3.如果遇到灰色的节点 则输出节点的值
     */
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<ColorNode> stack = new Stack<>();
        stack.push(new ColorNode(root, "white"));
        while (!stack.isEmpty()) {
            ColorNode color = stack.pop();
            if (color.color.equals("white")) {
                if (color.node.right != null) stack.push(new ColorNode(color.node.right, "white"));
                stack.push(new ColorNode(color.node, "gray"));
                if (color.node.left != null) stack.push(new ColorNode(color.node.left, "white"));

            } else {
                list.add(color.node.val);
            }
        }
        return list;
    }
}
