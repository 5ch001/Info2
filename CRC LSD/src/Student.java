import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Class> registeredClasses;

    public Student(String name) {
        this.name = name;
        registeredClasses = new ArrayList<>();
    }

    public void registerForCourse(Class cl) {
        registeredClasses.add(cl);
        // Register for courses and choose labs
    }

    // Additional methods related to responsibilities
}