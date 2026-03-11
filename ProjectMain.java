import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    String group;
    double gpa;

    Student(String name, String group, double gpa) {
        this.name = name;
        this.group = group;
        this.gpa = gpa;
    }

    public String toString() {
        return name + " (" + group + ", GPA: " + gpa + ")";
    }
}

public class StreamPractice {

    public static void main(String[] args) {

        // list of integers
        List<Integer> numbers = Arrays.asList(3, 6, 8, 1, 4, 6, 8, 2);

        // list of strings
        List<String> words = Arrays.asList("apple", "banana", "avocado", "pear", "apricot");

        // list of students
        List<Student> students = Arrays.asList(
                new Student("Aliya", "SE-1", 3.8),
                new Student("Dana", "SE-1", 3.2),
                new Student("Amir", "SE-2", 3.9),
                new Student("Sara", "SE-2", 3.4),
                new Student("Bek", "SE-1", 3.7)
        );

        // filter even numbers
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();
        System.out.println("Even numbers: " + evenNumbers);

        // convert strings to uppercase
        List<String> upperWords = words.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println("Uppercase: " + upperWords);

        // count strings starting with 'a'
        long countA = words.stream()
                .filter(w -> w.startsWith("a"))
                .count();
        System.out.println("Words starting with 'a': " + countA);

        // sort numbers in descending order
        List<Integer> sortedDesc = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println("Sorted descending: " + sortedDesc);

        // find max and min numbers
        int max = numbers.stream().max(Integer::compare).get();
        int min = numbers.stream().min(Integer::compare).get();
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);

        // remove duplicate elements
        List<Integer> uniqueNumbers = numbers.stream()
                .distinct()
                .toList();
        System.out.println("Unique numbers: " + uniqueNumbers);

        // concatenate strings with comma
        String joined = words.stream()
                .collect(Collectors.joining(", "));
        System.out.println("Joined words: " + joined);

        // group students by group field
        Map<String, List<Student>> grouped =
                students.stream()
                        .collect(Collectors.groupingBy(s -> s.group));
        System.out.println("Grouped students: " + grouped);

        // calculate average gpa
        double avgGpa = students.stream()
                .mapToDouble(s -> s.gpa)
                .average()
                .orElse(0);
        System.out.println("Average GPA: " + avgGpa);

        // find first 3 students with gpa > 3.5
        List<Student> topStudents = students.stream()
                .filter(s -> s.gpa > 3.5)
                .limit(3)
                .toList();
        System.out.println("Top students: " + topStudents);

        // count students with gpa greater than 3.5
        long countStudents = students.stream()
                .filter(s -> s.gpa > 3.5)
                .count();
        System.out.println("Students with GPA > 3.5: " + countStudents);
    }
}