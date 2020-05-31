package 二叉树;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
 * <p>
 * 示例:
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * 输出: [3,2,1]
 * <p>
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 */
public class _0145二叉树的后序遍历 {

    /**
     * 1.递归解法
     */
    List<Integer> list = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return list;
        // 后序遍历：左-右-根
        // 左
        postorderTraversal(root.left);
        // 右
        postorderTraversal(root.right);
        // 根
        list.add(root.val);
        return list;
    }

    /**
     * 2.迭代器
     * 从根节点开始依次迭代，弹出栈顶元素输出到输出列表中，然后依次压入它的所有孩子节点，按照从上到下、从左至右的顺序依次压入栈中
     * 后序遍历的顺序是从下到上、从左至右，所以需要将输出列表逆序输出
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.addFirst(node.val);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return output;
    }

    /**
     * 3.阿里面试奇葩要求 只用栈去做二叉树的后序遍历 不能依靠队列去状态比较
     */
    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            boolean rightHandled = false;
            if (stack.peek() == null) {
                stack.pop();
                rightHandled = true;
            }
            if (stack.peek().right == null || rightHandled) {
                root = stack.pop();
                result.add(root.val);
                root = null;
            } else {
                root = stack.peek().right;
                stack.push(null);
            }
        }
        return result;
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
     * 4.解题思路：颜色标记法
     * 1.使用颜色标记节点的状态 新节点为白色 已访问节点为灰色
     * 2.如果遇到的节点为白色 则将其标记为灰色 然后将右子节点、自身、左子节点依次入栈
     * 3.如果遇到灰色的节点 则输出节点的值
     */
    public List<Integer> postorderTraversal4(TreeNode root) {
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
