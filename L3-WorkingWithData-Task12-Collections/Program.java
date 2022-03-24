import java.util.*;

public class Program {
    public static void main(String[] args) {
        ArrayList<Course> course1 = new ArrayList<Course>();
        Course maths = new Course("Maths", 20, "John S"); 
        course1.add(maths);
        
        Course physics = new Course("Physics", 10, "Albert E");
        course1.add(physics);
        
        Course economics = new Course("Economics", 30, "John K");
        course1.add(economics);
        
        Course psychology = new Course("Psychology", 5, "Edmund F");
        course1.add(psychology);
        
        Course philosophy = new Course("Philosophy", 7, "Marcus A");
        course1.add(philosophy);

        System.out.println("original list of courses: " + course1);

        // Sort the list by numberOfStudents
        Collections.sort(course1, new CourseStudentsComparator());

        System.out.println("sorted list: " + course1);

        // Swap elements
        Collections.swap(course1, 1, 2);
        
        System.out.println("swapped list: " + course1);

        // Create new ArrayList
        ArrayList<Course> course2 = new ArrayList<Course>();
        course2.addAll(course1);
        System.out.println("new list of courses: " + course2);

        course2.add(new Course("Java 101", 55, "Dr. P Green"));
        course2.add(new Course("Advanced Programming", 93, "Prof. M Milton"));

        System.out.println("updated list of courses: " + course2);

        // Sort the list by% courseName
        Collections.sort(course2);
        System.out.println("sorted list (by course name) of courses: " + course2);

        // Search for Java 101
        Course courseSearch = new Course("Java 101", 55, "Dr. P Green");
        int index = Collections.binarySearch(course2, courseSearch);
        System.out.println("Index of 'Java 101' is: " + index);

        // Disjoint
        if (!Collections.disjoint(course1, course2)) {
            course1.retainAll(course2);
            System.out.println("The common courses between the old and new list are: " + course1);
        }

        // Course with most and least students
        System.out.println("the course with most students is: " + Collections.max(course2, new CourseStudentsComparator()));

        System.out.println("the course with least students is: " + Collections.min(course2, new CourseStudentsComparator()));
    }
}