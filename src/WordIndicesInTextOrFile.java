import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordIndicesInTextOrFile {

    public TrieNode root=null;

    public List<List<Integer>> findIndices(String text, List<String> words) {
        root=new TrieNode();
        String[] wordsArray=text.split(" ");
        int sum=0;
        for(int i=0;i<wordsArray.length;i++){
            insertInTrie(wordsArray[i],sum );
            sum+=wordsArray[i].length()+1;
        }

        List<List<Integer>> list=new ArrayList<>();

        for(String word:words){
            List<Integer> allIndex=searchInTrie(word);
            if(allIndex.isEmpty())
                allIndex.add(-1);
            list.add(allIndex);
        }
        return list;
    }

    public void insertInTrie(String word, int index){
        TrieNode node=root;
        for(int i=0;i<word.length();i++){
            if(node.child.get(word.charAt(i))!=null)
                node=node.child.get(word.charAt(i));
            else{
                TrieNode trieNode=new TrieNode();
                node.child.put(word.charAt(i),trieNode);
                node=trieNode;
            }
        }
        node.list.add(index);
    }

    public List<Integer> searchInTrie(String word){

        TrieNode node=root;
        for(int i=0;i<word.length();i++){
            if(node.child.get(word.charAt(i))!=null)
                node=node.child.get(word.charAt(i));
            else{
                return new ArrayList<Integer>();
            }
        }
        return node.list;
    }

    class TrieNode{
        char val;
        HashMap<Character,TrieNode> child=null;
        ArrayList<Integer> list=null;
        TrieNode(){
            child=new HashMap<>();
            list=new ArrayList<>();
        }
    }

    public static void main(String args[]){
        WordIndicesInTextOrFile wordIndicesInTextOrFile=new WordIndicesInTextOrFile();
        List<String> list=new ArrayList<>();
        list.add("you");list.add("are");list.add("very");list.add("handsome");
        List<List<Integer>> list1=wordIndicesInTextOrFile.findIndices("you are very very smart",list);
        for(List<Integer> list2:list1){
            System.out.println("");
            for(Integer i:list2){
                System.out.print(i);
            }
        }
    }

}
