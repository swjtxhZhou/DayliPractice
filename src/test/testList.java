package test;

import java.util.ArrayList;
import java.util.List;

public class testList {
    public static void main(String[] args){
        List<Integer> integerList = new ArrayList<Integer>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        System.out.println(integerList.indexOf(2));
    }
}
