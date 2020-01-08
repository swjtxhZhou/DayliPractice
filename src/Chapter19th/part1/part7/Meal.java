package Chapter19th.part1.part7;

public class Meal {
    public static void main(String[] args){
        for(int i= 0;i<6;i++){
            for(Course course:Course.values()){
                Food food = course.randomSelection();
                System.out.println(food);
            }
            System.out.println("--------------");
        }
    }
}
