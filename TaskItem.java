import java.util.ArrayList;


abstract class TaskItem {

    protected String title;
    protected int daysLeft;
    protected int hoursNeeded;
    protected boolean done;

    TaskItem(String title, int daysLeft, int hoursNeeded) {
        this.title = title;
        this.daysLeft = daysLeft;
        this.hoursNeeded = hoursNeeded;
        this.done = false;
    }

    void complete() {
        done = true;
    }

    boolean isDone() {
        return done;
    }

    int getHoursNeeded() {
        return hoursNeeded;
    }

    String getTitle() {
        return title;
    }

    abstract void printInfo();
    abstract int calculatePriority();
}


class HomeworkTask extends TaskItem {

    HomeworkTask(String title, int daysLeft, int hoursNeeded) {
        super(title, daysLeft, hoursNeeded);
    }

    @Override
    void printInfo() {
        System.out.println("Homework: " + title +
                " | Days left: " + daysLeft +
                " | Priority: " + calculatePriority());
    }

    @Override
    int calculatePriority() {
        if (done) return 0;
        return daysLeft <= 0 ? 10 : 8 - daysLeft;
    }
}


class ExamTask extends TaskItem {

    ExamTask(String title, int daysLeft, int hoursNeeded) {
        super(title, daysLeft, hoursNeeded);
    }

    @Override
    void printInfo() {
        System.out.println("Exam: " + title +
                " | Study hours: " + hoursNeeded +
                " | Priority: " + calculatePriority());
    }

    @Override
    int calculatePriority() {
        if (done) return 0;
        return (hoursNeeded / (daysLeft + 1));
    }
}


class ActivityTask extends TaskItem {

    ActivityTask(String title, int daysLeft, int hoursNeeded) {
        super(title, daysLeft, hoursNeeded);
    }

    @Override
    void printInfo() {
        System.out.println("Activity: " + title +
                " | In: " + daysLeft + " days" +
                " | Priority: " + calculatePriority());
    }

    @Override
    int calculatePriority() {
        if (done) return 0;
        return 6 - daysLeft;
    }
}


public class Main {

    public static void main(String[] args) {

        TaskItem task;

        task = new HomeworkTask("OOP Assignment", 2, 5);
        task.printInfo();

        task = new ExamTask("Calculus Exam", 4, 18);
        task.printInfo();

        task = new ActivityTask("Programming Club", 3, 2);
        task.printInfo();

        System.out.println("\n=== Task List ===");

        ArrayList<TaskItem> tasks = new ArrayList<>();

        tasks.add(new HomeworkTask("Java Final Project", 3, 10));
        tasks.add(new ExamTask("Physics Midterm", 5, 12));
        tasks.add(new ActivityTask("Hackathon Event", 1, 6));

        for (TaskItem t : tasks) {
            t.printInfo();
        }

      
        tasks.get(1).complete();

        System.out.println("\n=== After Completing One Task ===");

        for (TaskItem t : tasks) {
            t.printInfo();
        }

  
        int total = 0;

        for (TaskItem t : tasks) {
            if (!t.isDone()) {
                total += t.getHoursNeeded();
            }
        }

        System.out.println("\nTotal Remaining Hours: " + total);

      
        TaskItem highest = tasks.get(0);

        for (TaskItem t : tasks) {
            if (t.calculatePriority() > highest.calculatePriority()) {
                highest = t;
            }
        }

        System.out.println("\nHighest Priority Task:");
        highest.printInfo();
    }
}
