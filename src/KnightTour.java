import java.util.LinkedList;
import java.util.Queue;

public class KnightTour {

    class RowColoumnPair{
        int r;
        int c;

        RowColoumnPair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    int[] r = new int[] {-2,-2,-1,-1,2,2,1,1};
    int[] c = new int[] {-1,1,-2,2,-1,1,-2,2};

    int find_minimum_number_of_moves(int rows, int cols, int start_row, int start_col, int end_row, int end_col) {
        int[][] dist=new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                dist[i][j]=-1;
            }
        }
        dist[start_row][start_col]=0;
        Queue<RowColoumnPair> q=new LinkedList<>();
        q.add(new RowColoumnPair(start_row, start_col));
        while (!q.isEmpty()){
            RowColoumnPair cur=q.poll();
            int curRow=cur.r;
            int curCol=cur.c;
            if(curRow==end_row && curCol==end_col){
                return dist[curRow][curCol];
            }
            for(int i=0;i<r.length;i++){
                int newRow=curRow+r[i];
                int newCol=curCol+c[i];
                if(isValid(newRow,newCol,rows,cols)){
                    if(dist[newRow][newCol]==-1){
                        dist[newRow][newCol]=dist[curRow][curCol]+1;
                        q.add(new RowColoumnPair(newRow,newCol));
                    }

                }
            }
        }
        return -1;

    }

    boolean isValid(int newRow, int newCol, int rows, int cols){
        if(newRow>=0 && newCol>=0 && newRow<rows && newCol<cols)
            return true;
        return false;
    }


    public static void main(String[] args){
        KnightTour knightTour=new KnightTour();

        System.out.println("Result is "+knightTour.find_minimum_number_of_moves(1,1,0,0,0,0));
    }

}
