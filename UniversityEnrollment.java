import java.util.HashMap;
import java.util.Scanner;

class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}

public class UniversityEnrollment {
    private static final int MAX_ENROLLMENT = 2;
    private static HashMap<String, Integer> courses = new HashMap<>();
    private static HashMap<String, String> prerequisites = new HashMap<>();

    static {
        courses.put("Advanced Java", 1);
        prerequisites.put("Advanced Java", "Core Java");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enroll in Course: ");
            String course = scanner.nextLine();

            if (!courses.containsKey(course)) {
                System.out.println("Course not found.");
                return;
            }

            if (courses.get(course) >= MAX_ENROLLMENT) {
                throw new CourseFullException("Error: CourseFullException - The course is already full.");
            }

            if (prerequisites.containsKey(course)) {
                System.out.print("Prerequisite: ");
                String completedCourse = scanner.nextLine();
                if (!completedCourse.equals(prerequisites.get(course))) {
                    throw new PrerequisiteNotMetException("Error: PrerequisiteNotMetException - Complete " + prerequisites.get(course) + " before enrolling in " + course + ".");
                }
            }

            courses.put(course, courses.get(course) + 1);
            System.out.println("Enrollment successful for " + course);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

