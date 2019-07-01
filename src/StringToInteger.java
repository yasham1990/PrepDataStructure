import javax.print.DocFlavor;
import java.util.LinkedList;
import java.util.Queue;

public class StringToInteger {

    public int atoi(String str){
        if(str==null || str.length()>1)
            return 0;

        str=str.trim();
        char flag='+';
        int i=0;
        if(str.charAt(0)=='-'){
            flag='-';
            i++;
        }
        else if(str.charAt(0)=='+')
            i++;

        double result=0;

        while (i<str.length() && str.charAt(i)>='0' && str.charAt(i)<='9'){
            result=result*10+(str.charAt(i)-'0');
            i++;
        }

        if(flag=='-')
            result=-result;

        if(result>Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if(result<Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int)result;

    }

    public void wallsAndGates(int[][] rooms) {
        int n=rooms.length;
        int m=rooms[0].length;
        boolean[][] visited=new boolean[n][m];
        Queue<Helper> q=new LinkedList();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(rooms[i][j]==0){
                    q.add(new Helper(i,j,0));
                }
            }
        }




        while(!q.isEmpty()){
            Helper help=q.poll();
            if(!visited[help.x][help.y]){
                visited[help.x][help.y]=true;
                rooms[help.x][help.y]=help.distance;
                if(isValid(help.x-1,help.y,n,m,rooms)){
                    q.add(new Helper(help.x-1,help.y,help.distance+1));
                }
                if(isValid(help.x,help.y-1,n,m,rooms)){
                    q.add(new Helper(help.x,help.y-1,help.distance+1));
                }
                if(isValid(help.x+1,help.y,n,m,rooms)){
                    q.add(new Helper(help.x+1,help.y,help.distance+1));
                }
                if(isValid(help.x,help.y+1,n,m,rooms)){
                    q.add(new Helper(help.x,help.y+1,help.distance+1));
                }
            }
        }
        System.out.println("here");

    }

    boolean isValid(int x,int y, int n, int m, int[][] rooms){
        if(x>=0 && y>=0 && x<n && y<m && rooms[x][y]==Integer.MAX_VALUE)
            return true;
        return false;
    }

    class Helper{
        int distance;
        int x;
        int y;
        Helper(int x,int y, int distance){
            this.x=x;
            this.y=y;
            this.distance=distance;
        }
    }

    public static void main(String[] args){
        StringToInteger st=new StringToInteger();
        st.wallsAndGates(new int[][]{{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1}
        ,{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}});

    }

}
