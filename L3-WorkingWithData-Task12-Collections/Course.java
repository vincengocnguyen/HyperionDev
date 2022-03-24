import java.util.*;

public class Course implements Comparable< Course > {
    String courseName;
    int numberOfStudents;
    String courseLecturer;

    public Course(String courseName, int numberOfStudents, String courseLecturer) {
        this.setCourseName(courseName);
        this.setNumberOfStudents(numberOfStudents);
        this.setCourseLecturer(courseLecturer);
    }

    public String getCourseName() {
        return courseName;
    }
    
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getNumberOfStudents() {
		return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }
    
    public String getCourseLecturer() {
        return courseLecturer;
    }

    public void setCourseLecturer(String courseLecturer) {
        this.courseLecturer = courseLecturer;
    }

    public String toString() {
        String output = "\n(" + courseName + ", " + courseLecturer + ", " + Integer.toString(numberOfStudents) + ")";
        
        return output;
    }

    public int compareTo(Course course) {
        return courseName.compareTo(course.getCourseName());
    }
}

