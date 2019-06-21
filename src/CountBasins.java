import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountBasins {

    public List<Integer> find_basins(List<List<Integer>> matrix) {
        int[][] basins=new int[matrix.size()][matrix.get(0).size()];

        for(int i=0;i<basins.length;i++){
            for(int j=0;j<basins[0].length;j++){
                basins[i][j]=-1;
            }
        }

        int basinIndex=0;

        for(int i=0;i<basins.length;i++){
            for(int j=0;j<basins[0].length;j++){
                if(helper(matrix, basins, i,j,basinIndex)==basinIndex)
                    basinIndex++;
            }
        }

        List<Integer> list=new ArrayList<>(basinIndex);
        for(int i=0;i<basinIndex;i++){
            list.add(0);
        }
        for(int i=0;i<basins.length;i++){
            for(int j=0;j<basins[0].length;j++){
                int index=basins[i][j];
                list.set(index, list.get(index)+1);
            }
        }
        Collections.sort(list,Collections.reverseOrder());
        return list;
    }

    int helper(List<List<Integer>> matrix, int[][] basins, int i, int j, int basinIndex){
        if(basins[i][j]==-1){
            int mRow=i;int mCol=j;
            if(j>0 && matrix.get(i).get(j-1) < matrix.get(mRow).get(mCol)){
                mCol=j-1;
                mRow=i;
            }
            if(i>0 && matrix.get(i-1).get(j) < matrix.get(mRow).get(mCol)){
                mRow=i-1;
                mCol=j;
            }
            if(i<matrix.size()-1 && matrix.get(i+1).get(j) < matrix.get(mRow).get(mCol)){
                mRow=i+1;
                mCol=j;
            }
            if(j<matrix.get(0).size()-1 && matrix.get(i).get(j+1) < matrix.get(mRow).get(mCol)){
                mRow=i;
                mCol=j+1;
            }
            if(mCol==j && mRow==i)
                basins[i][j]=basinIndex;
            else
            {
                basins[i][j]=helper(matrix, basins, mRow,mCol,basinIndex);
            }
        }
        return basins[i][j];
    }

}
