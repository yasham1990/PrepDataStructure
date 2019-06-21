import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TownPoliceFind {

    List<List<Integer>> findNearestStation(List<List<Character>> grids){
        int n=grids.size();
        int m=grids.get(0).size();
        List<List<Integer>> distance=new ArrayList<>();
        for(int i=0;i<n;i++){
            distance.add(new ArrayList<>());
            for(int j=0;j<m;j++){
                distance.get(i).add(-1);
            }
        }

        Queue<Node> q=new LinkedList<>();
        boolean[][] visited=new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) {
                if(grids.get(i).get(j)=='G')
                    q.add(new Node(i,j,0));
            }
        }

        while (!q.isEmpty()){
            Node node=q.remove();
            if(visited[node.x][node.y])
                continue;
            visited[node.x][node.y]=true;
            distance.get(node.x).set(node.y,node.distance);
            for(Node neighbour:getValidNeighbours(node.x,node.y,n,m,grids)){
                neighbour.distance=node.distance+1;
                q.add(neighbour);
            }
        }
        return distance;
    }

    List<Node> getValidNeighbours(int i, int j, int n,int m, List<List<Character>> grids){
        List<Node> result=new ArrayList<>();
        if(isValid(i-1,j,n,m,grids)){
            result.add(new Node(i-1,j,0));
        }
        if(isValid(i,j-1,n,m,grids)){
            result.add(new Node(i,j-1,0));
        }
        if(isValid(i+1,j,n,m,grids)){
            result.add(new Node(i+1,j,0));
        }
        if(isValid(i,j+1,n,m,grids)){
            result.add(new Node(i,j+1,0));
        }
        return result;
    }

    boolean isValid(int i, int j, int n,int m, List<List<Character>> grids){
        if(i<0 || j<0 || i>=n || j>=m || grids.get(i).get(j)!='O')
            return false;
        return true;
    }

    class Node{
        int x;
        int y;
        int distance;
        Node(int x,int y,int distance){
            this.x=x;
            this.y=y;
            this.distance=distance;
        }
    }
}
