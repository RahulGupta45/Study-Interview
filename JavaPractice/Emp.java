import java.util.Objects;

class Emp {
    private int id;
    private String name;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Two Emps are equal if their IDs are equal
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emp Emp = (Emp) o;
        return id == Emp.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Emp {" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}