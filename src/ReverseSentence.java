public class ReverseSentence {

    String reverse(String sentence){
        if(sentence==null || sentence.length()<2)
            return sentence;
        char[] arr=sentence.toCharArray();
        helper(arr,0,arr.length-1);
        int begin=0;
        for(int end=0;end<arr.length;end++){
            if(arr[end]==' '){
                helper(arr,begin,end-1);
                begin=end+1;
            }
        }
        helper(arr, begin, arr.length-1);
        return arr.toString();
    }

    void helper(char[] arr, int left, int right){
        char tmp;
        while (left < right) {
            tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }

}
