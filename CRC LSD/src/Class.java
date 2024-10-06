import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Class.java
public class Class {
    private String name;
    private String lectureDetails;
    private String labDetails;
    private List<Student> enrolledStudents;
    private Map<Student, Double> grades;

    public Class(String name, String lectureDetails, String labDetails) {
        this.name = name;
        this.lectureDetails = lectureDetails;
        this.labDetails = labDetails;
        enrolledStudents = new ArrayList<>();
        grades = new HashMap<>();
    }

    public void registerStudent(Student student) {
        enrolledStudents.add(student);
        // Provide access to class information for registration
    }

    public void addGrade(Student student, double grade) {
        grades.put(student, grade);
        // Allow teaching staff to add grades
    }

    // Additional methods related to responsibilities
}
