public class FindWordakaWordSearch {
    public boolean exist(char[][] board, String word) {
        if(board==null || word==null){
            return false;
        }

        int row=board.length;
        int column=board[0].length;
        boolean[][] visited=new boolean[row][column];
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(dfs(board,word,0,i,j,visited))
                    return true;
            }
        }
        return false;
    }


    public boolean dfs(char[][] board, String word,int index,int i, int j,  boolean[][] visited){
        if(index==word.length()){
            return true;
        }
        int row=board.length;
        int column=board[0].length;
        if(i<0|| i>=row || j<0 || j>=column || board[i][j]!=word.charAt(index) || visited[i][j] )
            return false;
        visited[i][j]=true;

        boolean res=(dfs(board, word, index + 1, i + 1, j, visited)
                || dfs(board, word, index + 1, i - 1, j, visited)
                || dfs(board, word, index + 1, i, j+1, visited)
                || dfs(board, word, index + 1, i, j-1, visited));

        visited[i][j]=false;
        return res;
    }
}
