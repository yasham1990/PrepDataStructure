//T(O)=O(|S|+|T|), we might visit twice every element for S and T once.
//S(O)=O(|S|+|T|), worst case
//Better version would be to remove all the extra characters of S and

public class MinimumWindowString {
    public String minWindow(String str, String pat) {
        int len=str.length();
        int lenPat=pat.length();

        if(lenPat>len)
            return "";

        int[] hashPat=new int[256];
        int[] hashStr=new int[256];

        for(int i=0;i<lenPat;i++){
            hashPat[pat.charAt(i)]++;
        }
        int start=0;
        int start_index=-1;
        int min_length=Integer.MAX_VALUE;

        int count=0;
        for(int j=0;j<len;j++){
            hashStr[str.charAt(j)]++;

            if(hashPat[str.charAt(j)]!=0 && hashStr[str.charAt(j)]<= hashPat[str.charAt(j)])
                count++;

            if(count==lenPat){
                while(hashStr[str.charAt(start)]>hashPat[str.charAt(start)] || hashPat[str.charAt(start)]==0)
                {
                    if(hashStr[str.charAt(start)]>hashPat[str.charAt(start)])
                        hashStr[str.charAt(start)]--;
                    start++;

                }

                int len_window=j-start+1;
                if(min_length>len_window){
                    start_index=start;
                    min_length=len_window;
                }
            }

        }
        if(start_index==-1)
            return "";

        // Return substring starting from start_index
        // and length min_len
        return str.substring(start_index, start_index + min_length);
    }
}
