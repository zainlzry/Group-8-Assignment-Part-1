import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class User {
    private String username, password, userType;

    public User(String username, String password, String userType) {
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUserType() {
        return userType;
    }
}

class Student extends User {
    public Student(String username, String password) {
        super(username, password, "Student");
    }

    public void registerForTeach(String course) {
        System.out.println(getUsername()+ "has registered to lecture this course" + course);
    }

    public void registerForCourse(String courseName) {
        System.out.println(getUsername() + " has registered for the course: " + courseName);
    }
}

public class assignment {
    private static Map<String, User> userDatabase = new HashMap<>();


public static void main(String[] args) {
        
        userDatabase.put("Admin", new User("Admin", "password123", "Admin"));
        userDatabase.put("Student", new Student("Student", "password123"));
        userDatabase.put("Lecturer", new User("Lecturer", "password123","Lecturer"));

        // Login
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (userAuthenticater(username, password)) {
            User currentUser = userDatabase.get(username);
            System.out.println("Login successful. Welcome, " + currentUser.getUsername() + "!");

            if ("Student".equals(currentUser.getUserType())) {
                // Course registration for students
                System.out.print("Enter the course you want to register for: ");
                String courseName = scanner.nextLine();
                ((Student) currentUser).registerForCourse(courseName);
            } else if ("Lecturer".equals(currentUser.getUserType())) {
                System.out.println("Choose an action:");
            System.out.println("1. View Students Registeres in your courses");
            System.out.println("2. View courses assigned to you");
            System.out.println("Type 'quit' to exit");

            System.out.print("Enter your choice: ");
            String input = scanner.next();

            switch (input.toLowerCase()) {
                case "1":
                    System.out.println("Adam, 1221234141");
                    System.out.println("Aiman, 1233167851");
                    System.out.println("Hasif, 131314141414");
                    System.out.println("You viewed all students");
                    break;
                case "2":
                    System.out.println("TCP1101 Programming Fundamentals");
                    System.out.println("TMA1101 Calculus");
                    System.out.println("TMA1201 Discrete Structure and Probablity");
                    System.out.println("You viewed assigned courses");
                    break;
                case "quit":
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            }   
            else {
                System.out.println("Admin functionality or other user types can be implemented here.");
                System.out.println("Choose an action:");
            System.out.println("1. View all students with assigned courses");
            System.out.println("2. View all lecturers with assigned courses");
            System.out.println("Type 'quit' to exit");

            System.out.print("Enter your choice: ");
            String input = scanner.next();

            switch (input.toLowerCase()) {
                case "1":
                    System.out.println("1. Calculus");
                    System.out.println("2. Programming Fundamentals");
                    System.out.println("3. Database Design");
                    System.out.print("Enter your choice: ");
                    String input1 = scanner.next();
                    switch (input1.toLowerCase()) {
                        case "1": // Calculus
                            System.out.println("Adam, 1221234141");
                            System.out.println("Aiman, 1233167851");
                            System.out.println("Hasif, 131314141414");
                            break;
                        case "2": // Programming Fundamentals
                            System.out.println("Adam, 1221234141");
                            System.out.println("Aiman, 1233167851");
                            System.out.println("Hasif, 131314141414");
                            break;
                        case "3": // Database Design
                            System.out.println("Adam, 1221234141");
                            System.out.println("Aiman, 1233167851");
                            System.out.println("Hasif, 131314141414");
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                    break;
                case "2":
                    System.out.println("1. Calculus");
                    System.out.println("2. Programming Fundamentals");
                    System.out.println("3. Database Design");
                    System.out.print("Enter your choice: ");
                    String input2 = scanner.next();
                    switch (input2.toLowerCase()) {
                        case "1":
                            System.out.println("Dr. Sharaf, Dr. Tea, Dr. Nur Erlida");
                            break;
                        case "2":
                            System.out.println("Dr. Sharaf, Dr. Tea, Dr. Nur Erlida");
                            break;
                        case "3":
                            System.out.println("Dr. Sharaf, Dr. Tea, Dr. Nur Erlida");
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                    break;
                case "quit":
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
            
        } else {
            System.out.println("Wrong ID/Password!!!");
        }
    }

    private static boolean userAuthenticater(String username, String password) {
        User user = userDatabase.get(username);
        return user != null && user.getPassword().equals(password);
    }
}
