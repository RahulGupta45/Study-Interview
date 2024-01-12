import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo{
    public static void main(String[] args) {
        List<Student> ls=new ArrayList<>();
        ls.add(new Student(1,"Prasad", Arrays.asList(20,30,40,60)));
        ls.add(new Student(2,"Pratiksha",Arrays.asList(20,30,80,90)));
        ls.add(new Student(3,"Prasanthi",Arrays.asList(20,30,10,90)));

        List<Student> collect = ls.stream().filter(stu -> stu.getMarks().stream().filter(mark -> mark > 80).count() >=
                    1).collect(Collectors.toList());
        System.out.println(collect);

    }
}
