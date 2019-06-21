import java.util.ArrayList;
import java.util.List;

public class MatrixTrieProblem {

    public void insert(String word, TrieNode root) {
        if(word!=null && word.length()>0)
        {
            TrieNode ws=root;
            for(int i=0;i<word.length();i++)
            {
                if(ws.child[word.charAt(i)-'a']==null)
                    ws.child[word.charAt(i)-'a']=new TrieNode();
                else
                    ws.cnt++;
                ws=ws.child[word.charAt(i)-'a'];
            }
            ws.isWord=true;
        }
    }

    public void remove(String word, TrieNode root){
        int l = word.length();
        TrieNode curr = root;
        for (int i = 0; i < l; i++) {
            int idx = word.charAt(i) - 'a';
            if (curr == null || curr.child[idx] == null){
                break;
            }
            TrieNode tmp = curr.child[idx];
            tmp.cnt--;
            if (tmp.cnt == 0) {
                curr.child[idx] = null;
            }
            curr = tmp;
        }
    }

    public boolean isValid(int x, int y, List<String> arr, TrieNode trie) {
        int n=arr.size();
        int m=arr.get(0).length();
        if(x<0 || y<0 || x>=n || y>=m)
            return false;
        if(trie==null)
            return false;

        if(trie.child[arr.get(x).charAt(y)-'a']==null)
            return false;
        return true;
    }

    List<String> matrixSolver(List<String> list, List<String> arr){
        TrieNode root=new TrieNode();
        for(String word:list){
            insert(word,root);
        }
        int n=arr.size();
        int m=arr.get(0).length();
        boolean[][] visited=new boolean[n][m];
        List<String> result=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int curChar=arr.get(i).charAt(m)-'a';
                if(root.child[curChar]!=null){
                    List<String> foundWords=new ArrayList<>();
                    String word=""+arr.get(i).charAt(m);
                    dfs(i,j,arr,visited,root,root.child[curChar],foundWords,word);
                    result.addAll(foundWords);
                }
            }
        }
        return result;
    }

    void dfs(int x,int y, List<String> arr, boolean[][] visited, TrieNode root, TrieNode node, List<String> result, String word){

        if(node!=null && node.isWord){
            node.isWord=false;
            result.add(word);
            remove(word,root);
        }
        visited[x][y]=true;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if(i==0 && j==0)
                    continue;
                if(isValid(i,j,arr,node) && !visited[i][j]){
                    int curChar=arr.get(x+i).charAt(y+j)-'a';
                    word=word+arr.get(x+i).charAt(y+j);
                    dfs(i,j,arr,visited,root,root.child[curChar],result,word);
                    word=word.substring(0,word.length()-1);
                }
            }
        }
        visited[x][y]=false;
    }

    class TrieNode {
        boolean isWord;
        int cnt;
        TrieNode[] child = new TrieNode[26];

        TrieNode() {
            cnt=1;
            for(int i=0;i<26;i++) {
                child[i] = null;
            }
        }
    }
}
