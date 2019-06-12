import java.util.*;

public class WordLadder2 {
   /* public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int l=beginWord.length();
        Map<String, List<String>> map=new HashMap<>();
        List<List<String>> result=new ArrayList<List<String>>();
        for(String curWord:wordList){
            for(int i=0;i<l;i++) {
                String word = curWord.substring(0, i) + '*' + curWord.substring(i + 1, l);
                List<String> transformations = null;
                if (map.containsKey(word))
                    transformations = map.get(word);
                else
                    transformations = new ArrayList<>();
                transformations.add(curWord);
                map.put(word, transformations);
            }
        }

        Queue<Pair> q=new LinkedList<>();
        List<String> temp=new ArrayList<>();
        temp.add(beginWord);
        q.add(new Pair(beginWord,temp));
        Map<String,Boolean> visited=new HashMap<>();
        visited.put(beginWord,true);

        List<String> resultList=new ArrayList<>();
        while (!q.isEmpty()) {
            for (int j = 0; j < q.size(); j++) {
                Pair curPair = q.remove();
                String curWord = curPair.word;
                List<String> levelPath = curPair.levelPath;

                for (int i = 0; i < l; i++) {
                    String word = curWord.substring(0, i) + '*' + curWord.substring(i + 1, l);
                    if (map.containsKey(word)) {
                        for (String adWord : map.get(word)) {
                            if (adWord.equals(endWord)) {
                                levelPath.add(endWord);
                                result.add(resultList);
                                *//*resultList = new ArrayList<>(resultList);
                                resultList.remove(resultList.get(resultList.size() - 1));
                                continue;*//*
                            }

                            if (!visited.containsKey(adWord)) {
                                visited.put(adWord, true);
                                q.add(new Pair(adWord, level + 1));
                            }
                        }
                    }
                }
                resultList.add(curWord);

            }
        }

        return result;
    }*/



}
class Pair{
    String word;
    List<String> levelPath;
    Pair(String word, List<String> levelPath){
        this.word=word;
        this.levelPath=levelPath;
    }
}
