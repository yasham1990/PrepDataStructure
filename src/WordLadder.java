import java.util.*;

public class WordLadder {

    //Graph problem as words transformation relates to adjacent list
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int l=beginWord.length();
        Map<String, List<String>> map=new HashMap<>();

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
        q.add(new Pair(beginWord,1));
        Map<String,Boolean> visited=new HashMap<>();
        visited.put(beginWord,true);

        while (!q.isEmpty()){
            Pair curPair=q.remove();
            String curWord=curPair.word;
            Integer level=curPair.level;

            for(int i=0;i<l;i++) {
                String word = curWord.substring(0, i) + '*' + curWord.substring(i + 1, l);
                if(map.containsKey(word)) {
                    for (String adWord : map.get(word)) {
                        if (adWord.equals(endWord))
                            return level + 1;

                        if (!visited.containsKey(adWord)){
                            visited.put(adWord,true);
                            q.add(new Pair(adWord,level+1));
                        }
                    }
                }
            }

        }

        return 0;
    }


    String[] string_transformation(String[] words, String start, String stop) {
        int l=beginWord.length();
        Map<String, List<String>> map=new HashMap<>();

        for(String curWord:words){
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
        q.add(new Pair(beginWord,1));
        Map<String,Boolean> visited=new HashMap<>();
        visited.put(start,true);

        while (!q.isEmpty()){
            Pair curPair=q.remove();
            String curWord=curPair.word;
            Integer level=curPair.level;

            for(int i=0;i<l;i++) {
                String word = curWord.substring(0, i) + '*' + curWord.substring(i + 1, l);
                if(map.containsKey(word)) {
                    for (String adWord : map.get(word)) {
                        if (adWord.equals(stop\))
                            return level + 1;

                        if (!visited.containsKey(adWord)){
                            visited.put(adWord,true);
                            q.add(new Pair(adWord,level+1));
                        }
                    }
                }
            }

        }



    }

    boolean only_one_char_difference(int len, String str1, String str2)    {
        int difference = 0;
        for (int i = 0; i < len; i++)
        {
            if (str1.charAt(i) != str2.charAt(i))
            {
                // If there is already one miss match, and now we have found another.
                if (difference == 1)
                {
                    return false;
                }
                difference++;
            }
        }
        // If difference == 0, it means strings are same. So, difference == 1 is needed.
        return difference == 1;
    }


    public static void main(String args[]){
        WordLadder vE=new WordLadder();
        List<String> list=new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        System.out.println("result is "+ vE.ladderLength("hit","cog",list));
    }

    class Pair {
        String word;
        Integer level;

        Pair(String word, Integer level) {
            this.word = word;
            this.level = level;
        }
    }

}
