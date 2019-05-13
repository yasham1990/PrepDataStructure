package basic;

//Contains DFS and BFS

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeOrderTraversing {


    public void preorder(TreeNode node){
        if(node==null)
            return;
        System.out.println(node.val);
        preorder(node.left);
        preorder(node.right);
    }
    public void postorder(TreeNode node){
        if(node==null)
            return;
        preorder(node.left);
        preorder(node.right);
        System.out.println(node.val);
    }
    public void inorder(TreeNode node){
        if(node==null)
            return;
        System.out.println(node.val);
        preorder(node.left);
        System.out.println(node.val);
        preorder(node.right);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList();
        if(root==null)
            return result;
        preorderViaStack(root, result);
        return result;
    }

    public void preorderViaStack(TreeNode node, List<Integer> l){
        if(node==null)
            return;
        Stack<TreeNode> stack=new Stack<>();
        stack.add(node);
        while (!stack.isEmpty()){
            TreeNode n=stack.pop();
            l.add(n.val);
            if(n.right!=null)
                stack.push(n.right);
            if(n.left!=null)
                stack.push(n.left);
        }
    }

    public void inorderViaStack(TreeNode node, List<Integer> l){
        if(node==null)
            return;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode curNode=node;
        while ( curNode!=null ||!stack.isEmpty()){
            while(curNode!=null){
                stack.push(curNode);
                curNode=curNode.left;
            }
            curNode=stack.pop();
            l.add(curNode.val);
            curNode=curNode.right;
        }
    }

    public void postorderViaStack(TreeNode node, List<Integer> l){
        if(node==null)
            return;
        Stack<TreeNode> stack=new Stack<>();
        Stack<TreeNode> stackReverse=new Stack<>();
        stack.add(node);
        while (!stack.isEmpty()){
            TreeNode n=stack.pop();
            stackReverse.push(n);
            if(n.left!=null)
                stack.push(n.left);
            if(n.right!=null)
                stack.push(n.right);
        }
        while (!stackReverse.isEmpty()){
            l.add(stackReverse.pop().val);
        }
    }

}
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int val){
        this.val=val;
    }
}
