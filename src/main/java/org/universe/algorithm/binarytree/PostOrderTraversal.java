package org.universe.algorithm.binarytree;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal {

    /**
     *
     * 【思路】
     *
     * 左=》右=>D
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Postorder Traversal.
     * Memory Usage: 37.7 MB, less than 19.80% of Java online submissions for Binary Tree Postorder Traversal.
     *
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        travel(results, root);
        return results;
    }
    private void travel(List<Integer> list, TreeNode treeNode) {
        if(treeNode == null) {
            return;
        }
        // 左
        if(treeNode.left != null) {
            travel(list, treeNode.left);
        }
        // 右边
        if(treeNode.right != null) {
            travel(list, treeNode.right);
        }
        // 数据
        list.add(treeNode.val);
    }
}
