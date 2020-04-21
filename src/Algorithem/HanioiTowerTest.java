package Algorithem;

public class HanioiTowerTest {
    public static void hanoiTower(int num,char a,char b,char c){
        if(num==1){
            System.out.println("第1个盘从"+a+"->"+c);
        }else{
            hanoiTower(num-1,a,c,b);//把最上面的所有盘移动到B
            System.out.println("第"+num+"个盘从"+a+"->"+c);
            hanoiTower(num-1,b,a,c);//把B塔所有盘从B->C
        }
    }
    public static void main(String[] args){
        hanoiTower(5,'A','B','C');
    }
}