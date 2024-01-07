public class Lecturer {
    private String name;

    public Lecturer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toCSVString() {
        return "Lecturer," + name;
    }
}

