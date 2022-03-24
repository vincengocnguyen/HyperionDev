import java.util.*;

public class CourseStudentsComparator implements Comparator<Course> {
    public int compare(Course course1, Course course2) {
        return course1.getNumberOfStudents() - course2.getNumberOfStudents();
    }
}