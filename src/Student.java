import java.util.*;

public class Student {
    String name, group;
    Integer course;
    Map<String, Integer> marks;

    public Student(String name, String group, Integer course){
        this.name = name;
        this.group = group;
        this.course = course;
    }

    public Student(String name, String group, Integer course, Map<String, Integer> map){
        this.name = name;
        this.group = group;
        this.course = course;
        this.marks = map;
    }

    public int midMark(){
        Integer sum = 0, cnt = 0;
        for(Map.Entry<String, Integer> pair: this.marks.entrySet()){
            sum += pair.getValue();
            cnt++;
        }
        return sum / cnt;
    }

    public void addMarks(){
        System.out.println("Input subject and mark through spase or input \"enter\" if you want to finish:");
        Map<String, Integer> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        while(true){
            String subject = scanner.next();
            if(subject.equals("enter")){
                break;
            }
            Integer mark = scanner.nextInt();
            if(map.containsKey(subject)){
                System.out.println("Key is already exist, do you want replace it(y/n): ");
                String c = scanner.next();
                while(!c.equals("y") && !c.equals("n") && !c.equals("\n")){
                    System.out.println("Key is already exist, do you want replace it(y/n): ");
                }
                if(c.equals("n")){
                    continue;
                }
            }
            map.put(subject, mark);
        }
        marks = map;
        System.out.println("Final marks: " + map);
    }
}

