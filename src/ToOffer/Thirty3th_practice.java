package ToOffer;

public class Thirty3th_practice {
    public boolean VerifySquenceOfBST(int[] sequence){
        if(sequence == null||sequence.length==0){return false;}
        return verify(sequence,0,sequence.length-1);
    }
    public boolean verify(int[] sequence,int first,int last){
        if(last-first<=1){return true;}
        int rootVal = sequence[last];
        int cutIndex=0;
        while(sequence[cutIndex]<=rootVal&&cutIndex<last){
            cutIndex++;
        }
        for(int i=cutIndex;i<last;i++){
            if(sequence[i]<rootVal){
                return false;
            }
        }
        return verify(sequence,first,cutIndex-1)&&verify(sequence,cutIndex,last);
    }
}
