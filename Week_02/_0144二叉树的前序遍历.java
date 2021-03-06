package 二叉树;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
     * <p>
     * 时间复杂度：O(n) 每个节点都要访问一次
     * 空间复杂度：O(n) 有可能此二叉树的高度 和 节点的数量 一致
     */
    private List<Integer> list = new ArrayList<>();

    //    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<Integer>();
//        // 前序遍历 = 根 左 右
//        preorderTraversal(root, list);
//        return list;
//    }
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return null;
        // 根
        list.add(root.val);
        // 左
        preorderTraversal(root.left);
        // 右
        preorderTraversal(root.right);
        return list;
    }

    /**
     * 解题思路：
     * 1.可以用栈代替递归
     * 2.每次先把根节点压入栈内
     * 3.循环栈 只要不为空就一直循环
     * 4.循环内弹出栈顶元素给返回结果
     * 5.由于栈是前进后出 所以每次要先把右节点压栈再压左节点 根-左-右
     * <p>
     * 时间复杂度：O(n) 每个节点都要访问
     * 空间复杂度：O(n) 二叉树的所有节点
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            TreeNode left = node.left, right = node.right;
            if (right != null) {
                stack.push(right);
            }
            if (left != null) {
                stack.push(left);
            }
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
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<ColorNode> stack = new Stack<>();
        stack.push(new ColorNode(root, "white"));
        while (!stack.isEmpty()) {
           ColorNode color = stack.pop();
            if (color.color.equals("white")) {
                if (color.node.right != null) stack.push(new ColorNode(color.node.right, "white"));
                if (color.node.left != null) stack.push(new ColorNode(color.node.left, "white"));
                stack.push(new ColorNode(color.node, "gray"));

            } else {
                list.add(color.node.val);
            }
        }
        return list;
    }
}
