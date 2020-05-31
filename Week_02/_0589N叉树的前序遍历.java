package 二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 * 返回其前序遍历: [1,3,5,6,2,4]。
 * <p>
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 * 公司：亚马逊在半年内面试中考过
 * <p>
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class _0589N叉树的前序遍历 {
    /**
     * 解题思路：
     * 1.先递归 根节点 然后从左到右遍历每个子树
     * 2.每个子树的顺序按根节的顺序来
     * 3.整体进行前序遍历
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private List<Integer> list = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root == null) return list;
        // 前序遍历 根-左-右
        list.add(root.val);

        if (root.children != null && root.children.size() > 0) {
            for (Node child : root.children) {
                preorder(child);
            }
        }
        return list;
    }

    /**
     * 解题思路：
     * 1.迭代栈的方式
     * 2.将每个根节点压入栈 每次弹出栈顶是当前访问的节点
     * 3.将子节点压入栈进行下一步遍历
     * 4.由于是前序 所以要先压右再压左
     */
    public List<Integer> preorder2(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        // 前序遍历 根-左-右
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(node.val);
            List<Node> child = node.children;
            if (child != null) {
                int lenth = child.size();
                // 从右向左压栈
                for (int i = lenth - 1; i >= 0; i--) {
                    stack.add(child.get(i));
                }
            }
        }

        return list;
    }
}
