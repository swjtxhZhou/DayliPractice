package JavaToGod.IO;


import java.io.Serializable;

public class User1 implements Serializable {
    public String name;
    public Integer age;

    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public String toString(){
        return this.name+" "+this.age;
    }

}
