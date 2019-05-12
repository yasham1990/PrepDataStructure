//T(O):O(n)
//S(O):O(log(n))

public class MaxBinaryPathSum {

    int max_sum = Integer.MIN_VALUE;
    public int maxPath(TreeNode root) {
        if(root==null)
            return 0;
        int left_max=Math.max(maxPath(root.left),0);
        int right_max=Math.max(maxPath(root.right),0);

        int priceNew= root.val+left_max+right_max;

        max_sum=Math.max(priceNew, max_sum);

        return root.val+Math.max(left_max,right_max);

    }

    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return max_sum;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
