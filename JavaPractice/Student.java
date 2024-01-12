import java.util.List;

public class Student {

    private int stud_id;
    private String stud_name;
    private List<Integer> marks;

    public Student(int stud_id, String stud_name, List<Integer> marks) {
        this.stud_id = stud_id;
        this.stud_name = stud_name;
        this.marks = marks;
    }

    public int getStud_id() {
        return stud_id;
    }

    public void setStud_id(int stud_id) {
        this.stud_id = stud_id;
    }

    public String getStud_name() {
        return stud_name;
    }

    public void setStud_name(String stud_name) {
        this.stud_name = stud_name;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stud_id=" + stud_id +
                ", stud_name='" + stud_name + '\'' +
                ", marks=" + marks +
                '}';
    }
}