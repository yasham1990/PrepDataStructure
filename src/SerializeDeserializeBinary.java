import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SerializeDeserializeBinary {
    private String recurSerialize(TreeNode root, String str) {
        if(root==null){
            str+="null,";
        }
        else{
            str+=str.valueOf(root.val)+",";
            str = recurSerialize(root.left,str);
            str = recurSerialize(root.right,str);
        }
        return str;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return recurSerialize(root, "");
    }

    private TreeNode recurDeserialize(List<String> l) {
        if(l.get(0).equals("null")){
            l.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left=recurDeserialize(l);
        root.right=recurDeserialize(l);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
        return recurDeserialize(data_list);
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
