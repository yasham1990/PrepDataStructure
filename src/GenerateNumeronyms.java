import java.util.ArrayList;
import java.util.List;

public class GenerateNumeronyms {

    private String[] neuronyms(String word) {
        if(word.length()<=3){
            return new String[]{""};
        }

        int l=word.length();
        String t="";
        List<String> list= new ArrayList<>();
        for(int len=2;len<=l-2;len++){
            for(int i=1;i<=l-len-1;i++){
                t=word.substring(0,i)+len+word.substring(i+len,l);
                list.add(t);
            }
        }
        String[] result=new String[list.size()];
        for(int i=0;i<list.size();i++){
            result[i]=list.get(i);
        }
        return result;

    }

}
