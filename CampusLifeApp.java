import java.util.ArrayList;

class Course {
    private String name;
    private String instructor;
    private int credits;

    public Course(String name, String instructor, int credits) {
        this.name = name;
        this.instructor = instructor;
        this.credits = credits;
    }

    public String getName() {
        return name;
    }

    public String getInstructor() {
        return instructor;
    }

    public int getCredits() {
        return credits;
    }

    public String toString() {
        return "Course{name='" + name + "', instructor='" + instructor + "', credits=" + credits + "}";
    }
}

class AssignmentTask {
    private String title;
    private Course course;
    private int estimatedHours;
    private int daysUntilDue;
    private boolean completed;

    public AssignmentTask(String title, Course course, int estimatedHours, int daysUntilDue) {
        this.title = title;
        this.course = course;
        this.estimatedHours = estimatedHours;
        this.daysUntilDue = daysUntilDue;
        this.completed = false;
    }

    public String getTitle() { return title; }
    public Course getCourse() { return course; }
    public int getEstimatedHours() { return estimatedHours; }
    public int getDaysUntilDue() { return daysUntilDue; }
    public boolean isCompleted() { return completed; }

    public void markCompleted() {
        completed = true;
    }

    public boolean isUrgent() {
        return daysUntilDue <= 2 && !completed;
    }

    public String toString() {
        return "AssignmentTask{title='" + title +
                "', course='" + course.getName() +
                "', estHours=" + estimatedHours +
                ", dueIn=" + daysUntilDue +
                ", completed=" + completed + "}";
    }
}

class StudySession {
    private Course course;
    private int minutes;

    public StudySession(Course course, int minutes) {
        this.course = course;
        this.minutes = minutes;
    }

    public Course getCourse() { return course; }
    public int getMinutes() { return minutes; }

    public double hours() {
        return minutes / 60.0;
    }

    public String toString() {
        return "StudySession{course='" + course.getName() +
                "', minutes=" + minutes + "}";
    }
}

public class CampusLifeApp {

    public static void main(String[] args) {

        // Create courses
        Course oop = new Course("OOP", "Dr. Lee", 6);
        Course math = new Course("Discrete Math", "Dr. Kim", 5);
        Course english = new Course("English", "Ms. Brown", 3);

        ArrayList<Course> courses = new ArrayList<>();
        courses.add(oop);
        courses.add(math);
        courses.add(english);

        // Create assignments
        ArrayList<AssignmentTask> tasks = new ArrayList<>();
        tasks.add(new AssignmentTask("Lab 1", oop, 3, 1));
        tasks.add(new AssignmentTask("Project", oop, 10, 5));
        tasks.add(new AssignmentTask("Homework 2", math, 4, 2));
        tasks.add(new AssignmentTask("Essay", english, 5, 0));
        tasks.add(new AssignmentTask("Quiz Prep", math, 2, 3));

        // Create study sessions
        ArrayList<StudySession> sessions = new ArrayList<>();
        sessions.add(new StudySession(oop, 90));
        sessions.add(new StudySession(math, 120));
        sessions.add(new StudySession(oop, 60));
        sessions.add(new StudySession(english, 45));

        // Print courses
        System.out.println("=== COURSES ===");
        for (Course c : courses) {
            System.out.println(c);
        }

        // Print assignments + urgent highlight
        System.out.println("\n=== ASSIGNMENTS ===");
        for (AssignmentTask t : tasks) {
            if (t.isUrgent()) {
                System.out.println("⚠ URGENT: " + t);
            } else {
                System.out.println(t);
            }
        }

        // Calculate total remaining hours
        int totalHours = 0;
        for (AssignmentTask t : tasks) {
            if (!t.isCompleted()) {
                totalHours += t.getEstimatedHours();
            }
        }
        System.out.println("\nTotal remaining estimated hours: " + totalHours);

        // Total study time per course
        System.out.println("\n=== STUDY TIME PER COURSE ===");
        for (Course c : courses) {
            double totalStudyHours = 0;
            for (StudySession s : sessions) {
                if (s.getCourse().getName().equals(c.getName())) {
                    totalStudyHours += s.hours();
                }
            }
            System.out.println(c.getName() + ": " + totalStudyHours + " hours");
        }

        // Mark one assignment completed
        AssignmentTask completedTask = tasks.get(0);
        completedTask.markCompleted();

        System.out.println("\nUpdated assignment:");
        System.out.println(completedTask);

        // Recalculate remaining hours
        totalHours = 0;
        for (AssignmentTask t : tasks) {
            if (!t.isCompleted()) {
                totalHours += t.getEstimatedHours();
            }
        }

        System.out.println("New remaining estimated hours: " + totalHours);
    }
}