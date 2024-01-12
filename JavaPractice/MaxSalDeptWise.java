import java.util.*;
import java.util.stream.Collectors;

public class MaxSalDeptWise {

    public static void main(String[] args) {

        List<Employee> employeeList = Arrays.asList(new Employee("A",25,"male","IT",1000),
                new Employee("B",30,"female","CS",2000), new Employee("C",28,"male","IT",3000),new Employee("D",29,"female","CS",4000));

        //Dept Wise GroupBy
        Map<String, List<Employee>> groupByDept = employeeList.stream().collect(
                Collectors.groupingBy(e -> e.getDept()));

        //Max Sal Dept Wise
        Map<String, Employee> byDept = employeeList.stream().collect(
                Collectors.groupingBy(e -> e.getDept(),Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparingInt(e->e.getSal())), Optional::get
                ))
        );
        System.out.println(byDept);

        //Second max salary from employee
        Optional<Employee> emp = employeeList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSal).reversed()).skip(1).findFirst();
        System.out.println("Second Max "+emp.get());

        //Unique Dept
        employeeList.stream().map(Employee::getDept).distinct().forEach(print -> System.out.println(print));

        //Count of Dept
        Map<String,Long> freqDept = employeeList.stream().collect(Collectors.groupingBy(Employee::getDept,Collectors.counting()));
        System.out.println(freqDept);

        //Avg Age
        Map<String,Double> avgAge= employeeList.stream().collect(Collectors.groupingBy(Employee::getSex,Collectors.averagingInt(Employee::getAge)));
        System.out .println(avgAge);

        //Nth Highest Salary
        Employee nHighest = employeeList.stream()
                .sorted((e1, e2) -> e2.getSal() - e1.getSal())
                .skip(1)
                .findFirst().get();
        System.out.println(nHighest);

        String str = "aabbcczz";
        String sArray[] = str.split("");
        Map<String,Long> fmap = Arrays.stream(sArray)
                .collect(Collectors.groupingBy(i -> i,Collectors.counting()));
        System.out.println(fmap);

        int[] numbers = {1,2,3,4,5,2,6,7,8,9,1};
        Map<Integer,Long> fmap2 = Arrays.stream(numbers).boxed()
                .collect(Collectors.groupingBy(i -> i,Collectors.counting()));

        List<Integer> integerList = fmap2.entrySet().stream().filter(entry -> entry.getValue()>1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(integerList);

        List<String> list = List.of(new String[]{"hi", "hello", "bye"});
        System.out.println(list.stream().sorted((a1,a2) -> a2.length()-a1.length()).collect(Collectors.toList()));

        List<Student> ls=new ArrayList<>();
        ls.add(new Student(1,"Prasad", Arrays.asList(20,30,40,60)));
        ls.add(new Student(2,"Pratiksha",Arrays.asList(20,30,80,90)));
        ls.add(new Student(3,"Prasanthi",Arrays.asList(20,30,10,90)));

        List<Student> collect = ls.stream().filter(stu -> stu.getMarks().stream().filter(mark -> mark > 80).count() >=
                1).collect(Collectors.toList());
        System.out.println(collect);

    }
}