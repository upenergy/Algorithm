package org.universe.algorithm.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class FormerSequenceTraversal {

    public void preOrderTraverse1(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + "->");
            preOrderTraverse1(root.left);
            preOrderTraverse1(root.right);
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        travel(results, root);
        return results;
    }

    private void travel(List<Integer> list, TreeNode treeNode) {
        if(treeNode == null) {
            return;
        }
        // 数据
        list.add(treeNode.val);
        // 左
        if(treeNode.left != null) {
            travel(list, treeNode.left);
        }
        // 右边
        if(treeNode.right != null) {
            travel(list, treeNode.right);
        }
    }


    public List<Integer> preorderTraversalOther(TreeNode treeNode) {

        if (treeNode == null) {
            return null;
        }
        List<Integer> res = new LinkedList<>();
        if (treeNode == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            res.add(tmp.val);
            if (tmp.right != null) stack.push(tmp.right);
            if (tmp.left != null) stack.push(tmp.left);
        }
        return res;
    }
}
