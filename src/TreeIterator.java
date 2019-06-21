import java.util.Stack;

public class TreeIterator {

    Stack<TreeNode> stack=new Stack<>();
    public TreeIterator(TreeNode root){
        if(root!=null){
            checkLeft(root);
        }
    }

    public boolean hasNext(){
        return !stack.isEmpty();
    }

    public int next(){

        if(hasNext()){
            TreeNode node=stack.pop();
            if(node.right!=null)
                checkLeft(node.right);
            return node.val;
        }
        return -1;
    }

    private void checkLeft(TreeNode node){
        if(node!=null){
            stack.push(node);
            node=node.left;
        }

    }

}
