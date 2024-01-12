import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Emp> Emp = new HashSet<>();
        Emp.add(new Emp(101, "Ashish"));
        Emp.add(new Emp(102, "Rahul"));
        Emp.add(new Emp(103, "Ram"));

        Emp.add(new Emp(101, "Ashish"));
        Emp.add(new Emp(102, "Ant"));
        System.out.println(Emp);
        
        HashMap<Emp,String> EmpMap = new HashMap<Emp,String>();
        Emp Emp1 = new Emp(1,"Virat");
        Emp Emp2 = new Emp(1,"Virat");
        Emp Emp3 = new Emp(2,"Gill");

        EmpMap.put(Emp1,"India");
        EmpMap.put(Emp2,"Japan");
        EmpMap.put(Emp3,"Bharat");
        System.out.println(EmpMap);
    }
}