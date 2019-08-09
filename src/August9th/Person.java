package August9th;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;


public class Person {
    Person(String firstName,String lastName,int age){
        this.age = age;
        this.firstName= firstName;
        this.lastName = lastName;
    }

    private String firstName;
    private String lastName;
    private int age;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
    static final List<Person> guiltyPerson = Arrays.asList(new Person("a","a",1),
                                              new Person("b","b",2),
                                              new Person("c","c",3));
    public static void checkAndExecute(List<Person> personList,NameChecker nameChecker,Executer executer){
        for(Person p:personList){
            if(nameChecker.check(p)){
                executer.execute(p);
            }
        }
    }

    /**
     * 直接用Java 8函数式接口包里的Predicate<T>和Consumer<T>就可以了——因为他们这一对的接口定义和NameChecker/Executor其实是一样的
     * @param personList
     * @param predicate
     * @param consumer
     */
    public static void checkAndExecute2(List<Person> personList, Predicate<Person> predicate, Consumer<Person> consumer){
        for(Person p:personList){
            if(predicate.test(p)){
                consumer.accept(p);
            }
        }
    }

    /**
     * 用Iterable.forEach()取代foreach loop：
     * @param personList
     * @param predicate
     * @param consumer
     */
    public static void checkAndExecute3(List<Person> personList,Predicate<Person> predicate,Consumer<Person> consumer){
        personList.forEach(p->{if(predicate.test(p))consumer.accept(p);});
    }
    public static void checkAndExecute4(List<Person> personList,Predicate<Person> predicate,Consumer<Person> consumer){
        personList.stream().filter(p->predicate.test(p)).forEach(p->System.out.println(p.getFirstName()));
    }
    public static void main(String[] args){
        Person.checkAndExecute4(guiltyPerson,p->p.getLastName().startsWith("3"),p->System.out.println(p.getFirstName()));
        /**
         * 利用stream()替代静态函数：
         */
        guiltyPerson.stream().filter(p->p.getLastName().startsWith("3")).forEach(p->System.out.println(p.getFirstName()));
        guiltyPerson.stream().filter(p->p.getLastName().startsWith("3")).forEach(System.out::println);
        /**
         * Lambda配合Optional<T>可以使Java对于null的处理变的异常优雅
         */
    }
}
