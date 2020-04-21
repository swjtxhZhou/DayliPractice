package ToOffer;

public class Seventeen_practice {

    public void print1ToMax(int n){
        if(n<=0){return;}
        char[] number = new char[n];
        print1ToMax(number,0);
    }

    private void print1ToMax(char[] number,int digit){
        if(number.length==digit){
            printNumber(number);
        }
        for(int i=0;i<10;i++){
            number[digit] = (char)(i+'0');
            print1ToMax(number,digit+1);
        }
    }
    public void printNumber(char[] number){
        int index =0;
        while(index<number.length&&number[index]=='0'){
            index++;
        }
        while(index<number.length){
            System.out.print(number[index++]);
        }
        System.out.println();
    }
}
