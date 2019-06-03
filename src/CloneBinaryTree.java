public class CloneBinaryTree {

    TreeNode cloneTree(TreeNode root){
        if(root==null)
            return root;
        TreeNode cloneNode=new TreeNode(root.val);
        cloneNode.left=cloneTree(root.left);
        cloneNode.right=cloneTree(root.right);
        return cloneNode;
    }

}