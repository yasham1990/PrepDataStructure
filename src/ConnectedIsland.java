import java.util.List;

public class ConnectedIsland {

    int zombieCluster(List<String> zombies) {
        int result=0;
        boolean[] visited=new boolean[zombies.size()];
        for(int i=0;i<zombies.size();i++){
            if(!visited[i]) {
                result++;
                dfs(i,visited,zombies);
            }
        }

        return result;
    }

    void dfs(int i,boolean[] visited, List<String> zombies){
        visited[i]=true;
        for (int j=0;j<zombies.size();j++){
            if(zombies.get(i).charAt(j)=='1' && !visited[j]){
                dfs(j,visited,zombies);
            }
        }
        return;
    }


}
