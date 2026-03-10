import java.util.*;
import java.util.stream.Collectors;

public class Main {

    // Student class for tasks 8-11
    static class Student {
        String name;
        String group;
        double gpa;

        Student(String name, String group, double gpa) {
            this.name = name;
            this.group = group;
            this.gpa = gpa;
        }

        // Overriding toString to make the output readable
        @Override
        public String toString() {
            return String.format("%s (Group: %s, GPA: %.1f)", name, group, gpa);
        }
    }

    public static void main(String[] args) {
        // --- Sample Data ---
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 2, 4, 10, 9);
        List<String> strings = Arrays.asList("potato", "sixseven", "cherry", "apricot", "blueberry");
        List<Student> students = Arrays.asList(
                new Student("John", "A1", 3.8),
                new Student("Mary", "B2", 3.2),
                new Student("Peter", "A1", 4.0),
                new Student("Anna", "B2", 3.9),
                new Student("Alex", "A1", 3.1)
        );

        System.out.println("=== Stream API Exercise Results ===");

        // 1. Filter a list of integers to include only even numbers
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("1. Even numbers: " + evenNumbers);

        // 2. Convert a list of strings to uppercase
        List<String> upperCaseStrings = strings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("2. Uppercase strings: " + upperCaseStrings);

        // 3. Count how many strings start with a specific letter (e.g., 'a')
        long countStartsWithA = strings.stream()
                .filter(s -> s.startsWith("a"))
                .count();
        System.out.println("3. Strings starting with 'a': " + countStartsWithA);

        // 4. Sort a list of numbers in descending order
        List<Integer> sortedDescending = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("4. Descending order: " + sortedDescending);

        // 5. Find the maximum and minimum number in a list
        int maxVal = numbers.stream().max(Integer::compare).orElse(0);
        int minVal = numbers.stream().min(Integer::compare).orElse(0);
        System.out.println("5. Max: " + maxVal + ", Min: " + minVal);

        // 6. Remove duplicate elements from a list
        List<Integer> uniqueNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("6. Unique elements: " + uniqueNumbers);

        // 7. Concatenate a list of strings into a single comma-separated string
        String joinedStrings = strings.stream()
                .collect(Collectors.joining(", "));
        System.out.println("7. Joined string: " + joinedStrings);

        // 8. Group a list of Student objects by their group field
        Map<String, List<Student>> groupedByGroup = students.stream()
                .collect(Collectors.groupingBy(s -> s.group));
        System.out.println("8. Students grouped by class: " + groupedByGroup);

        // 9. Calculate the average GPA of all students
        double averageGpa = students.stream()
                .mapToDouble(s -> s.gpa)
                .average()
                .orElse(0.0);
        System.out.printf("9. Average GPA: %.2f\n", averageGpa);

        // 10. Find the first 3 students that match a condition (GPA > 3.5)
        List<Student> firstThreeTopStudents = students.stream()
                .filter(s -> s.gpa > 3.5)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("10. First 3 students with GPA > 3.5: " + firstThreeTopStudents);

        // 11. Find how many students have a GPA greater than 3.5
        long countTopStudents = students.stream()
                .filter(s -> s.gpa > 3.5)
                .count();
        System.out.println("11. Total students with GPA > 3.5: " + countTopStudents);
    }
}
