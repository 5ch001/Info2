
import java.util.ArrayList;
import java.util.List;

public class TeachingStaff {
    private String name;
    private List<Class> classesTaught;

    public TeachingStaff(String name) {
        this.name = name;
        this.classesTaught = new ArrayList<>();
    }

    public void addClass(Class cl) {
        if (!classesTaught.contains(cl)) {
            classesTaught.add(cl);
        } else {
            System.out.println("This class is already assigned to the teaching staff.");
        }
    }

    public void addGrade(Class cl, Student student, double grade) {
        if (classesTaught.contains(cl)) {
            cl.addGrade(student, grade);
        } else {
            System.out.println("Teaching staff is not assigned to this class.");
        }
    }

    public List<Class> getClassesTaught() {
        return classesTaught;
    }

    // Additional methods related to responsibilities
}