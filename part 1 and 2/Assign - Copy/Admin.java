import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Admin {
    public static final String lecturerFile = "lecturers.csv";
    public static final String courseFile = "courses.csv";

    public void createLecturer(String name) {
        Lecturer lecturer = new Lecturer(name);
        saveToCsv(lecturerFile, lecturer.toCSVString());
        System.out.println("You created a lecturer: " + name);
    }

    public void assignCourseToLecturer(String courseCode, String lecturerName) {
        String assigningCourse = "Assigned Course," + courseCode + "," + lecturerName;
        saveToCsv(courseFile, assigningCourse);
        System.out.println("You assigned course " + courseCode + " to lecturer: " + lecturerName);
    }

    private void saveToCsv(String filePath, String data) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
            writer.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

