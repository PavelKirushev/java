import java.util.HashMap;
import java.util.Map;

public class Main{
    public static void executeOperation(int x, int y, Operationable operationable){
        System.out.println(operationable.calculate(x, y));
    }
    public static void main (String args[]){
        Map<String, Integer> s1map = new HashMap<String, Integer>();
        s1map.put("math", 3);
        s1map.put("geometry", 2);
        Student s1 = new Student("Олег Цыганков", "Б23-601", 123, s1map);

        Map<String, Integer> s2map = new HashMap<String, Integer>();
        s2map.put("math", 5);
        s2map.put("physic", 4);
        Student s2 = new Student("Задрот Цыганков", "Б23-602", 123, s2map);

        Map<String, Integer> s3map = new HashMap<String, Integer>();
        s3map.put("physic", 4);
        s3map.put("geometry", 5);
        Student s3 = new Student("Олег Задротов", "Б23-603", 125, s3map);

        ListOfStudent list = new ListOfStudent();
        list.add(s1);
        list.add(s2);
        list.add(s3);

        list.printStudents(123);
        list.delete();

        list.printStudents(123);
    }
}

interface Operationable{
    int calculate(int x, int y);
}

interface Predicate{
    boolean check(int x);
}