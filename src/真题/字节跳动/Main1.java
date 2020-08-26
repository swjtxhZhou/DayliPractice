package 真题.字节跳动;

import java.util.Scanner;

public class Main1 {

        public static int findFixedNumInDynamicWindow(int[] nums,int target,int begin,int last){
//            int count =0;
//            for(int i=begin-1;i<last;i++){
//                if(nums[i]==target){
//                    count++;
//               }
//             }
            int f1= findFirstIndex(nums,target,begin,last);
            int f2 = findFirstIndex(nums,target+1,begin,last);
            return f2-f1;
        }
        private static int findFirstIndex(int[] nums,int target,int begin,int last){
            while(begin<last){
                int mid = begin+(last-begin)/2;
                if(target <= nums[mid]){
                    last = mid;
                }else{
                    begin = mid+1;
                }
            }
            return begin;
        }

        public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);
            int userNumber = scanner.nextInt();
            System.out.println(userNumber);
            //读取用户喜好记录数组
            int[] nums = new int[userNumber];
            for(int i=0;i<userNumber;i++){
                nums[i] = scanner.nextInt();
            }
            for(int num:nums){
                System.out.print(num+" ");
            }
            //读取查询数组
            int queryNums = scanner.nextInt();
            System.out.println(queryNums);
            int[][] numsList = new int[queryNums][3];
            for(int i=0;i<queryNums;i++){
                for(int j=0;j<3;j++){
                    numsList[i][j] = scanner.nextInt();
                }
            }
            for(int i=0;i<queryNums;i++){
                for(int j=0;j<3;j++){
                    System.out.print(numsList[i][j]+" ");
                }
                System.out.println();
            }
            //  int[] result = new int[queryNums];
            for(int i=0;i<queryNums;i++){
                System.out.println(findFixedNumInDynamicWindow(nums,numsList[i][2],numsList[i][0],numsList[i][1]));
            }
        }


}
