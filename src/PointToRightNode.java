import java.util.LinkedList;
import java.util.Queue;

public class PointToRightNode {

    public TreeNode pointRightNode(TreeNode root){
        if(root==null)
            return null;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        TreeNode right=null;
        while (!q.isEmpty()){
            right=null;
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(right!=null)
                    right.next_right=node;
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
                right=node;
            }
        }
        return root;
    }
    class TreeNode{
        TreeNode left;
        TreeNode right;
        TreeNode next_right;;
        int val;
        TreeNode(int val){
            this.val=val;
        }
    }

}
