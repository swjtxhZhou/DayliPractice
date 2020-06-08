package Algorithem.全排列;

import java.util.ArrayList;
import java.util.List;

public class Perm {
    /**
     * 从n个不同元素中任取m（m≤n）个元素，按照一定的顺序排列起来，叫做从n个不同元素中取出m个元素的一个排列。当m=n时所有的排列情况叫全排列。
     *
     * 公式：全排列数f(n)=n!(定义0!=1)
     */
    public List<Integer> res= new ArrayList<>();
    //交换函数
    private void swap(int a,int b){
        int temp = a;
        a = b;
        b = temp;
    }
    //全排列递归算法
    public void perm(int[] list,int level,int length){
        //list数组存放排列的数，level表示层代表几个数，length表示数组
        if(level==length){
            StringBuilder target = new StringBuilder();
            for(int i=0;i<=length;i++) {
                target.append(list[i]);
            }
            res.add(Integer.valueOf(target.toString()));
            return;
        }else{
            for(int i=level;i<=length;i++){
                swap(list[i],list[level]);
                perm(list,level+1,length);
                swap(list[i],list[level]);
            }
        }

    }
}
