import java.util.HashMap;

public class JoinWordsPalindrome {

    String[] join_words_to_make_a_palindrome(String words[]) {
        String[] result= new String[2];
        result[0]="NOTFOUND";
        result[1]="DNUOFTON";
        HashMap<String, Integer> map=new HashMap<>(words.length);
        for(String word:words){
            if(map.containsKey(word))
                map.put(word,map.get(word)+1);
            else
                map.put(word, 1);
        }
        String current="";
        for(String l_w:words){
            current="";
            for(int i=0;i<l_w.length();i++){
                current=l_w.charAt(i)+current;
                if(map.containsKey(current)){
                    if(current.equals(l_w)) {
                        if (map.get(l_w) > 1) {
                            result[0] = l_w;
                            result[1] = current;
                            return result;
                        }
                    }
                    else if(isPalindrome(l_w.substring(i+1))){
                        result[0]=l_w;
                        result[1]=current;
                        return result;
                    }
                }
            }
            current="";
            for(int i=l_w.length()-1;i>=0;i--){
                current=current+l_w.charAt(i);
                if(map.containsKey(current)){
                    if(current.equals(l_w)) {
                        if (map.get(l_w) > 1) {
                            result[0] = current;
                            result[1] = l_w;
                            return result;
                        }
                    }
                    else if(isPalindrome(l_w.substring(0,i))){
                        result[0]=current;
                        result[1]=l_w;
                        return result;
                    }
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String str){
        int l = 0;
        int n = str.length();
        while(l<n-l){
            if(str.charAt(l)!=str.charAt(n-1-l)){
                return false;
            }
            l++;
        }
        return true;
    }

    public static void main(String args[]){
        JoinWordsPalindrome j=new JoinWordsPalindrome();
        String[] d={"ant","dog","monkey"};
        String[] result=j.join_words_to_make_a_palindrome(d);
        for(String abc:result){
            System.out.println("result is "+abc);
        }
    }

}
