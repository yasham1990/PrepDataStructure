import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReachEndSnakeLadder {

    int distanceEnd(int n, List<Integer> arr){
        int[] path=new int[n];
        for(int i=0;i<n;i++){
            path[i]=arr.get(i);
            if(path[i]!=-1){
                path[i]=path[i]-1;
            }
        }
        return helper(n,path);
    }

    int helper(int n, int[] arr){
        boolean[] visited=new boolean[n];
        Queue<SnakeLadder> q=new LinkedList<>();
        SnakeLadder snakeLadder=new SnakeLadder();
        snakeLadder.index=0;
        snakeLadder.distance=0;
        q.add(snakeLadder);
        while (!q.isEmpty()){
            SnakeLadder sL=q.poll();
            if(!visited[sL.index]) {
                visited[sL.index] = true;
                if (sL.index == n - 1)
                    return sL.distance;


                for (int i = 1; i <= 6; i++) {
                    if (sL.index + i < n) {
                        SnakeLadder temp = new SnakeLadder();
                        if (arr[sL.index + i] == -1)
                            temp.index = sL.index + 1;
                        else
                            temp.index = arr[sL.index + i];
                        temp.distance = sL.distance + 1;
                        q.add(temp);
                    }
                }
            }
        }
        return -1;
    }

    class SnakeLadder{
        int index;
        int distance;
    }
}
