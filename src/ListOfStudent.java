import java.util.*;

public class ListOfStudent extends AbstractList<Student> {
    private final List<Student> list = new ArrayList<Student>();

    @Override
    public Student get(int index) {
        return list.get(index);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean add(Student element) {
        return list.add(element);
    }

    public boolean remove(String name) {
        for(Student student: list){
            if(student.name.equals(name)){
                list.remove(student);
                return true;
            }
        }
        return false;
    }

    public void delete(){
        Iterator<Student> iterator = list.iterator();
        while(iterator.hasNext()){
            if(iterator.next().midMark() < 3){
                iterator.remove();
            }
        }
    }

    public void printStudents(int course){
        for(Student student: list){
            if(student.course.equals(course)){
                System.out.println(student.name);
            }
        }
    }
}

