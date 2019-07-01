import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class CourseSchedule {

    /*private static List<Integer>[] adList=null;

    List<Integer> course_schedule(int n, List<List<Integer>> prerequisites){
        adList=new LinkedList[n];
        for (int i = 0; i < n; i++) {
            adList[i]=new LinkedList<>();
        }
        for(List<Integer> list:prerequisites){
            if(!list.isEmpty()){
                addEgde(list.get(1),list.get(0));
            }
        }
        return topologicalOrder(n);

    }

    void addEgde(int startV, int endV){
        adList[startV].add(endV);
    }

    List<Integer> topologicalOrder(int nVertices) {
        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[nVertices];
        List<Integer> output = new ArrayList<Integer>();

        for (int i = 0; i < nVertices; i++) {
            if (helper(i,visited,stack)) {
                output.add(-1);
                return output;
            }
        }
        while (!stack.isEmpty()){
            output.add(stack.pop());
        }
        return output;
    }

    boolean helper(int index, int[] visited, Stack<Integer> stack){
        if(visited[index]==2 || index==visited.length)
            return false;
        if(visited[index]==1)
            return true;
        visited[index]=1;
        for(int curIndex:adList[index]){
            if (helper(curIndex,visited,stack)) {
                return true;
            }
        }
        visited[index]=2;
        stack.push(index);
        return false;
    }

    public static void main(String[] args){
        CourseSchedule courseSchedule=new CourseSchedule();
    }*/

    List<Integer>[] adj=null;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        adj=new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i]=new LinkedList();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        int[] visited=new int[numCourses];
        Stack<Integer> stack=new Stack();

        for (int i = 0; i < numCourses; i++) {
            if(helper(i,visited, stack))
                return new int[]{};
        }
        int[] result=new int[stack.size()];
        int i=0;
        while(!stack.isEmpty()){
            result[i]=stack.pop();
            i++;
        }
        return result;

    }

    boolean helper(int index, int[] visited, Stack<Integer> stack){
        if(visited[index]==2 || index == visited.length )
            return false;
        if(visited[index]==1)
            return true;
        visited[index]=1;
        for(Integer curIndex:adj[index]){
            if(helper(curIndex,visited, stack))
                return true;
        }
        visited[index]=2;
        stack.push(index);
        return false;
    }
}
