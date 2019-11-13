package Chapter17th.part2.part7th;

import java.util.PriorityQueue;

public class ToDoList extends PriorityQueue<ToDoList.ToDoItem> {
    static class ToDoItem implements Comparable<ToDoItem>{
        private char primary;
        private int secondary;
        private String item;
        public ToDoItem(char pri,int sec,String td){
            primary= pri;
            secondary = sec;
            item = td;
        }
        public int compareTo(ToDoItem arg){
            if(primary > arg.primary){
                return +1;
            }else if(primary == arg.primary){
                if(secondary > arg.secondary){
                    return +1;
                }else if(secondary == arg.secondary){
                    return 0;
                }
            }
            return -1;
        }
        public String toString(){
            return Character.toString(primary)+secondary+": "+item;
        }
    }
    public void add(String td,char pri,int sec){
        super.add(new ToDoItem(pri, sec, td));
    }
    public static void main(String[] args){
        ToDoList toDoList = new ToDoList();//这是一个优先队列。其中的元素toDoItem重写了compareTo
        toDoList.add("Empty trash",'C',4);
        toDoList.add("Free dog",'A',2);
        toDoList.add("Free bird",'B',7);
        toDoList.add("Mow lawn",'C',3);
        toDoList.add("Water lawn",'A',1);
        toDoList.add("Feed cat",'B',1);
        while(!toDoList.isEmpty()){
            System.out.println(toDoList.remove());
        }
    }
}
