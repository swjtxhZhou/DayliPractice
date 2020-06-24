package ToOffer.practice;

public class To39_Boyer_Moore_Majoruty_Vote_Algorithm {
    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
     * 这是一个特殊的算法需要记住！！！
     * 多数投票问题，可以利用 Boyer-Moore Majority Vote Algorithm 来解决这个问题
     * 使得时间复杂度为 O(N)。
     *
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        int majority = array[0];
        for(int i=1,cnt=1;i<array.length;i++){
            cnt = majority==array[i]?cnt+1:cnt-1;
            if(cnt==0){
                //替换majority
                majority = array[i];
                cnt = 1;
            }
        }
        int cnt=0;
        for(int num:array){
            if(num==majority){
                cnt++;
            }
        }
        return cnt>array.length/2?majority:0;
    }

}
