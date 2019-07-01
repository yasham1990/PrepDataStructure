import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KMPSubstringSearch {

    public int[] getLPSArray(String p) {
        int[] lps = new int[p.length()];
        lps[0] = 0;
        int len = 0;
        for (int i = 1; i < lps.length; ) {
            if (p.charAt(len) == p.charAt(i)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }


    public int[] KMP(String t, String p) {
        if(t.length()<p.length())
            return new int[]{-1};
        List<Integer> l=new ArrayList<>();
        int[] lps=getLPSArray(p);

        int tj=0,pj=0;
        while(tj<t.length() && pj<p.length()){
            if(t.charAt(tj)==p.charAt(pj)){
                tj++;
                pj++;
                if(pj==p.length()){
                    l.add(tj-pj);
                    pj=lps[pj-1];
                }
            }
            else{
                if(pj>0)
                    pj=lps[pj-1];
                else
                    tj++;
            }
        }
        if(l.size()<1)
            return new int[]{-1};
        int[] result=new int[l.size()];
        for(int i=0;i<l.size();i++){
            result[i]=l.get(i);
        }
        return result;
    }

    public static void main(String args[]){
        KMPSubstringSearch j=new KMPSubstringSearch();
        String d="ababcedab";
        int[] result=j.getLPSArray(d);
        for(int abc:result){
            System.out.println("result is "+abc);
        }
    }

    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())
            return false;
        Map<Character, Character> map=new HashMap<>();

        for(int i=0;i<s.length();i++){
            Character temp=null;
            if(map.containsKey(s.charAt(i))){
                temp=map.get(s.charAt(i));
            }
            if(temp==null)
                map.put(s.charAt(i),t.charAt(i));
            else if(temp==t.charAt(i))
                return false;

        }
        return true;
    }

}
