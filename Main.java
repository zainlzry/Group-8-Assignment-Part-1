import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static String studentFile = "students.csv";

    public static void main(String[] args) {
        Admin admin = new Admin();
        Scanner input = new Scanner(System.in);
        System.out.print("Do you want to create a student or lecturer? Enter 'student' or 'lecturer': ");
        String userType = input.nextLine().toLowerCase();

        if ("student".equals(userType)) {
            
            System.out.print("Enter the new students id: ");
            int newId = input.nextInt();
            System.out.print("Enter the new students name: ");
            input.nextLine(); 
            String newName = input.nextLine();             
            boolean idExist = readStudentFromFile().stream().anyMatch(s -> s.getId() == newId);

            if (idExist == false) {
                ArrayList<Student> students = readStudentFromFile();
                students.add(new Student(newId, newName));
                System.out.println("Saved students in file " + studentFile);
                saveStudentToFile(students);
            } else {
                System.out.println("Cant add id " + newId + " because it is in use.");
            }
        } else if ("lecturer".equals(userType)) {
            System.out.print("Enter the lecturers name: ");
            String newLecturerName = input.nextLine();

            admin.createLecturer(newLecturerName);
            System.out.println("Saved lecturers in file " + Admin.lecturerFile);

            
            System.out.print("Enter course code: ");
            String courseCode = input.nextLine();

            
            admin.assignCourseToLecturer(courseCode, newLecturerName);
            System.out.println("Saved courses in file " + Admin.courseFile);
        } else {
            System.out.println("Invalid choice. Please enter 'student' or 'lecturer'");
        }

        input.close();
    }

    private static ArrayList<Student> readStudentFromFile() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(studentFile));
            for (String line : lines) {
                String[] items = line.split(",");
                int id = Integer.parseInt(items[0]);
                students.add(new Student(id, items[1]));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return students;
    }

    private static void saveStudentToFile(ArrayList<Student> students) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < students.size(); i++)
              sb.append(students.get(i).toCSVString() + "\n");
        try {
      Files.write(Paths.get(studentFile), sb.toString().getBytes());
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
  }
}
