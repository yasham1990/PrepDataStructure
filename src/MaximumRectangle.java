import java.util.Stack;

public class MaximumRectangle {

    //T(O): T(n^2)
    //S(O): S(1)
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int maxarea = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == '1'){
                    dp[i][j]=j==0?1:dp[i][j-1]+1;
                    int width=dp[i][j];

                    for(int k=i;k>=0;k--){
                        width=  Math.min(width, dp[k][j]);
                        maxarea = Math.max(maxarea, width * (i - k + 1));
                    }

                }
            }
        }
        return maxarea;
    }

    private int largestRectangleAreaStack(int[] heights) {
        Stack< Integer > stack = new Stack < > ();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1){
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return maxarea;
    }

    //T(O):T(MN)
    //S(O):S(M)
    public int maximalRectangleBetterDPWithStack(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int maxarea = 0;
        int[] dp = new int[matrix[0].length];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
            }
            maxarea = Math.max(maxarea, largestRectangleAreaStack(dp));
        }
        return maxarea;
    }
}
