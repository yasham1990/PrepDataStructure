import java.util.ArrayList;
import java.util.List;

public class NQueensProblem {

    public int totalNQueens(int n) {
        int result;
        boolean[] slashDiagonal=new boolean[n+n-1];
        boolean[] backSlashDiagonal=new boolean[n+n-1];
        boolean[] cols=new boolean[n];
        List<List<String>> list=new ArrayList();
        helper(0,n,cols,slashDiagonal,backSlashDiagonal,list, new ArrayList<String>());
        for (List<String> list1:list){
            for (String s:list1){
                System.out.print(s);
                System.out.print(",");
            }
            System.out.println("");
        }
        return list.size();
    }

    void helper(int row, int n, boolean[] cols,boolean[] slashDiagonal,boolean[] backSlashDiagonal
            ,List<List<String>> result, List<String> list){
        if(row==n){
            result.add(new ArrayList<>(list));

            return;
        }
        for(int i=0;i<n;i++){
            if(isValid(row,i,n,cols,slashDiagonal,backSlashDiagonal)){
                char[] c=new char[]{'.','.','.','.'};
                c[i]='q';
                list.add(new String(c));
                cols[i]=true;
                slashDiagonal[row+i]=true;
                backSlashDiagonal[row-i+n-1]=true;
                helper(row+1,n,cols,slashDiagonal,backSlashDiagonal,result,list);
                cols[i]=false;
                slashDiagonal[row+i]=false;
                backSlashDiagonal[row-i+n-1]=false;
                list.remove(list.size()-1);
            }
        }
    }

    boolean isValid(int row,int col, int n, boolean[] cols,boolean[] slashDiagonal,boolean[] backSlashDiagonal){
        if(slashDiagonal[row+col] || cols[col] || backSlashDiagonal[row-col+n-1])
            return false;
        return true;
    }

    public static void main(String[] args){
        NQueensProblem nQueensProblem=new NQueensProblem();
        nQueensProblem.totalNQueens(4);
    }
}
