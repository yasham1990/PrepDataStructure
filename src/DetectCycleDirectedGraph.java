import java.util.ArrayList;
import java.util.List;

public class DetectCycleDirectedGraph {

    boolean hasCycle(int n, int m, List<List<Integer>> edgesList){
        List<Integer>[] adjList=new ArrayList[n];
        for(int i=0;i<n;i++){
            adjList[i]=new ArrayList<>();

         }

        for(int i=0;i<m;i++){
            List<Integer> list=edgesList.get(i);
            adjList[list.get(0)].add(list.get(1));
        }

        boolean visited[]=new boolean[n];
        boolean isPresentInRecur[]=new boolean[n];

        for(int i=0;i<n;i++){
            if(helper(adjList,visited,isPresentInRecur,i))
                return true;

        }
        return false;
    }

    boolean helper(List<Integer>[] adjList,boolean visited[], boolean isPresentInRecur[], int curInd ){
        if(isPresentInRecur[curInd]==true)
            return true;
        if(visited[curInd]==true)
            return false;
        visited[curInd]=true;
        isPresentInRecur[curInd]=true;
        for(Integer i:adjList[curInd]){
            if(helper(adjList,visited,isPresentInRecur,i))
                return true;

        }
        isPresentInRecur[curInd]=false;
        return false;
    }
}
