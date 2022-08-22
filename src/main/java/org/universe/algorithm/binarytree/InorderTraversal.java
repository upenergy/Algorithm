public class InorderTraversal {
    
    public List<Integer> inorderTraversal(TreeNode root) {
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
        // 中
        list.add(treeNode.val);
        // 右边
        if(treeNode.right != null) {
            travel(list, treeNode.right);
        }
    }
}
