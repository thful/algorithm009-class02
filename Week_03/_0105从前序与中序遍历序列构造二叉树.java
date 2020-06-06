package 二叉树;

import entity.TreeNode;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * <p>
 * 返回如下的二叉树：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 */
public class _0105从前序与中序遍历序列构造二叉树 {
    public void buildTree(int[] preorder, int[] inorder) {
        buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public TreeNode buildTree(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
        if (p_start == p_end || i_start == i_end) return null;
        // 根节点
        int rootVal = preorder[p_start];
        TreeNode root = new TreeNode(rootVal);
        // 在中序遍历中找根节点
        int root_index = 0;
        for (int i = i_start; i < i_end; i++) {
            if (rootVal == inorder[i]) {
                root_index = i;
                break;
            }
        }
        int left = root_index - i_start;
        // 构造左子树
        root.left = buildTree(preorder, p_start + 1, p_start + left + 1, inorder, i_start, root_index);
        // 构造右子树
        root.right = buildTree(preorder, p_start + left + 1, p_end, inorder, root_index + 1, i_end);
        return root;
    }
}
