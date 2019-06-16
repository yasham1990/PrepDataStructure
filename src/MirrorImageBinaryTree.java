import java.util.LinkedList;
import java.util.Queue;

public class MirrorImageBinaryTree {

    public void mirrorImage(TreeNode root){
        if(root==null)
            return;
        Queue<TreeNode> q=new LinkedList<>();

        q.add(root);
        while (!q.isEmpty()){
            TreeNode node=q.poll();
            TreeNode temp=node.left;
            node.left=node.right;
            node.right=temp;
            if(node.left!=null)
                q.add(node.left);
            if(node.right!=null)
                q.add(node.right);
        }

    }
}
