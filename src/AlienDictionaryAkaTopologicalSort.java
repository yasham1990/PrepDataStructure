import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class AlienDictionaryAkaTopologicalSort {

    private List<Integer>[] adList=null;

    void printOrderOfCharacter(String[] words, int nVertices){
        adList=new LinkedList[nVertices];

        for (int i = 0; i < nVertices; i++) {
            adList[i]=new LinkedList<>();
        }

        for(int i=0;i<words.length-1;i++){
            String word1=words[i];
            String word2=words[i+1];

            for(int j=0;j<Math.min(word1.length(),word2.length());j++){
                if(word1.charAt(j)!=word2.charAt(j)){
                    addEgde(word1.charAt(j)-'a',word2.charAt(j)-'a');
                    break;
                }
            }
        }

        topologicalOrder(nVertices);

    }

    void addEgde(int startV, int endV){
        adList[startV].add(endV);
    }

    void topologicalOrder(int nVertices) {
        Stack<Integer> stack = new Stack<>();

        boolean[] visited = new boolean[nVertices];
        for (int i = 0; i < nVertices; i++) {
            visited[i] = false;
        }

        for (int i = 0; i < nVertices; i++) {
            if (!visited[i])
                helper(i, visited, stack);
        }

        while (!stack.isEmpty()){
            System.out.print(" "+(char)('a'+stack.pop()));
        }
    }

    void helper(int index, boolean[] visited, Stack<Integer> stack){
        visited[index]=true;
        for(int curIndex:adList[index]){
            if(!visited[curIndex])
                helper(curIndex,visited,stack);
        }
        stack.push(index);
    }

    public static void main(String[] args){
        AlienDictionaryAkaTopologicalSort alienDictionaryAkaTopologicalSort=new AlienDictionaryAkaTopologicalSort();
        alienDictionaryAkaTopologicalSort.printOrderOfCharacter(new String[]{"caa","aaa","aab"},3);
    }
}
