public class LargestBST {

    class BSThelper{
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int maxCount=0;
        boolean isValid=false;
    }

    public int findLargestBST(TreeNode root){
        BSThelper bsThelper=new BSThelper();
        helper(root,bsThelper);
        return bsThelper.maxCount;
    }

    public int helper(TreeNode root, BSThelper bsThelper){
        if(root==null) {
            bsThelper.isValid=true;
            bsThelper.min=Integer.MAX_VALUE;
            bsThelper.max=Integer.MIN_VALUE;
            return 0;
        }

        int leftNodeValue=helper(root.left,bsThelper);
        boolean isLeftBST=bsThelper.isValid && bsThelper.max<=root.val;
        int min=bsThelper.min, max=bsThelper.max;

        int rightNodeValue=helper(root.right,bsThelper);
        boolean isRightBST=bsThelper.isValid && bsThelper.min>=root.val;

        if(isLeftBST && isRightBST){
            bsThelper.isValid=true;
            bsThelper.min= Math.min(bsThelper.min,Math.min(root.val,min));
            bsThelper.max= Math.max(bsThelper.max,Math.max(root.val,max));
            bsThelper.maxCount=Math.max(bsThelper.maxCount,1+leftNodeValue+rightNodeValue );
        }
        bsThelper.isValid=false;
        return -1;
    }
}
