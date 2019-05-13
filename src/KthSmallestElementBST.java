import java.util.Stack;

public class KthSmallestElementBST {
    //Inorder Traversal seems the first choice
    //T(O)=O(N), S(O)=O(N)

    //We can do this by stack as well
/*
T(O) : O(H+K), where HH is a tree height. This complexity is defined by the stack, which contains at least H + kH+k elements, since before starting to pop out one has to go down to a leaf. This results in O(logN+k) for the balanced tree and O(N+k) for completely unbalanced tree with all the nodes in the left subtree.
S(O) : O(H+k), the same as for time complexity, O(N+k) in the worst case, and O(logN+k) in the average case.
 */

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode curNode=root;
        while(curNode!=null || !stack.isEmpty()){
            while(curNode!=null){
                stack.push(curNode);
                curNode=curNode.left;
            }
            curNode=stack.pop();
            if(--k==0)
                return curNode.val;
            curNode=curNode.right;

        }
        return -1;
    }


}
