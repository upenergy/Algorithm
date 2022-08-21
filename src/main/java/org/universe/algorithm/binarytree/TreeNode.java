package org.universe.algorithm.binarytree;

import java.util.List;

public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode() {}
        public TreeNode(int val) { this.val = val; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    public TreeNode sortedListToBST(List<Integer> list) {
        if(list.size() <= 0) {
            return null;
        }
        return generateTree(list, 0, list.size()-1);
    }

    private TreeNode generateTree(List<Integer> list, int start, int end) {
        //此时没有数字，将 null 加入结果中
        if(start > end) {
            return null;
        }
        // root 节点
        // 1 2 3 4 5
        int rootIndex = (start + end)/2;
        int rootVal = list.get(rootIndex);
        TreeNode treeNode = new TreeNode(rootVal);
        // left
        treeNode.left = generateTree(list, start, rootIndex-1);
        // right
        treeNode.right = generateTree(list, rootIndex+1, end);
        return treeNode;

    }
}
