import java.util.Stack;

public class LargestRectangleArea {

    //T(O): T(n^2)
    //S(O): S(1)
    public int largestRectangleArea(int[] heights) {
        int maxarea=0;
        for(int i=0;i<heights.length;i++){
            int minheight=Integer.MAX_VALUE;
            for(int j=i;j<heights.length;j++){
                minheight=Math.min(minheight,heights[j]);
                maxarea=Math.max(maxarea, minheight*(j-i+1));
            }
        }
        return maxarea;
    }

    //T(O): T(nlogn) worst case: T(n^2)
    //S(O): S(1)
    public int largestRectangleAreaDivideNConquer(int[] heights) {

        return largestRectangleAreaRecur(heights,0,heights.length-1);
    }

    private int largestRectangleAreaRecur(int[] heights, int start, int end){

        if(start>end)
            return 0;
        int minIndex=start;
        for(int i=start;i<=end;i++){
            if(heights[minIndex]>heights[i]){
                minIndex=i;
            }
        }

        return Math.max(heights[minIndex] * (end - start + 1), Math.max(largestRectangleAreaRecur(heights, start, minIndex - 1),
                largestRectangleAreaRecur(heights, minIndex + 1, end)));

    }

    public int largestRectangleAreaStack(int[] heights) {
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
}
