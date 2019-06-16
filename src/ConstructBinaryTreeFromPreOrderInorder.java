import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConstructBinaryTreeFromPreOrderInorder {


    int cur_index;
    public TreeNode constructBinaryTree(List<Integer> inorder, List<Integer> preorder) {


        Map<Integer, Integer> map=new HashMap<>(inorder.size());
        cur_index=0;
        for(int i=0;i<inorder.size();i++){
            map.put(inorder.get(i),i);
        }

        return construct(inorder, preorder, 0,inorder.size()-1,map);
    }


    TreeNode construct(List<Integer> inorder, List<Integer> preorder, int left, int right, Map<Integer,Integer> map){
        if(left>right)
            return null;

        TreeNode node=new TreeNode(preorder.get(cur_index));
        cur_index++;
        if(left==right)
            return node;
        int indexInOrder=map.get(node.val);
        node.left=construct(inorder, preorder, left,indexInOrder-1,map);
        node.right=construct(inorder, preorder, indexInOrder+1,right,map);
        return node;
    }


}
