public class TrieProblem {

    private TrieNode root;
    /** Initialize your data structure here. */
    public TrieProblem() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word!=null && word.length()>0)
        {
            TrieNode ws=root;
            for(int i=0;i<word.length();i++)
            {
                if(ws.child[word.charAt(i)-'a']==null)
                    ws.child[word.charAt(i)-'a']=new TrieNode();
                ws=ws.child[word.charAt(i)-'a'];
            }
            ws.isWord=true;
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word!=null && word.length()>0)
        {
            TrieNode ws=root;
            for(int i=0;i<word.length();i++)
            {
                if(ws.child[word.charAt(i)-'a']==null)
                    return false;
                ws=ws.child[word.charAt(i)-'a'];
            }
            return ws.isWord;
        }
        return false;
    }


    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix!=null && prefix.length()>0)
        {
            TrieNode ws=root;
            for(int i=0;i<prefix.length();i++)
            {
                if(ws.child[prefix.charAt(i)-'a']==null)
                    return false;
                ws=ws.child[prefix.charAt(i)-'a'];
            }
            return true;
        }
        return false;
    }


}

class TrieNode{
    boolean isWord;
    TrieNode[] child=new TrieNode[26];
    TrieNode(){
    }
}
