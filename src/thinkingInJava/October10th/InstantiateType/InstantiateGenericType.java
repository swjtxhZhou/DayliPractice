package thinkingInJava.October10th.InstantiateType;

public class InstantiateGenericType {
    public static void main(String[] args){
        ClassAsFactory<Employee> fe = new ClassAsFactory<Employee>(Employee.class);
        System.out.println("fe succeed");
        try{
            ClassAsFactory<Integer> fi = new ClassAsFactory<Integer>(Integer.class);//Integer没有任何默认的构造器
        }catch(Exception e){
            System.out.println("fi failed");
        }
    }
}
