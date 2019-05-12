public class SerializeDeserializeBST {
    // Encodes a tree to a single string.
    int curIndex=0;
    public String serialize(TreeNode root) {
        if(root==null)
            return "";
        String result=recurserialize(root, "");
        result=result.substring(0, result.length()-1);
        System.out.println("VAl is "+result);
        return result;
    }

    private String recurserialize(TreeNode root,String str) {
        if(root==null)
            return null;
        else{
            str+=str.valueOf(root.val)+",";
            String leftValue=recurserialize(root.left, str);
            if(leftValue!=null)
                str=leftValue;
            String rightValue=recurserialize(root.right, str);
            if(rightValue!=null)
                str=rightValue;
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null || "".equals(data))
            return null;
        String[] arrString=data.split(",");
        return recurdeserialize(arrString, Integer.MIN_VALUE,
                Integer.MAX_VALUE);
    }

    private TreeNode recurdeserialize(String arr[],
                                      int min, int max) {
        if(curIndex>arr.length-1)
            return null;
        int a=Integer.parseInt(arr[curIndex]);
        TreeNode node=null;
        if(a>min && a<max){
            node=new TreeNode(a);
            curIndex+=1;
            node.left=recurdeserialize(arr, min,a);
            node.right=recurdeserialize(arr, a,max);
        }
        return node;
    }

    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int val){
            this.val=val;
        }
    }

}
