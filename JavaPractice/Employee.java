public class Employee {

    private String name;
    private int age;

    private String sex;
    private int sal;
    private String dept;


    public Employee(String name, int age, String sex, String dept, int sal) {
        this.sex = sex;
        this.age = age;
        this.name = name;
        this.dept = dept;
        this.sal = sal;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", sal=" + sal +
                ", dept='" + dept + '\'' +
                '}';
    }
}
