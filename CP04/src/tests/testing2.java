package tests;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class testing2 {
    public static void main(String[] args) {
        Map<Integer, String> gameMap = new HashMap<>();

        // Adding elements to the Map
        gameMap.put(1, "Ghost of Tsushima");
        gameMap.put(2, "Project Wingman");
        gameMap.put(3, "Carpe Diem");

        // Checking if a key exists
        if (gameMap.containsKey(3)) {
            System.out.println("Game with ID 3 exists in the map.");
        }

        // Removing an element
        gameMap.remove(1);

        // Iterating through the Map
        for (Map.Entry<Integer, String> entry : gameMap.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", Game: " + entry.getValue());
        }

        // STREAM METHOD !
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Andrew", "Amanda");

        // .FILTER() METHOD
        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());

        System.out.println(filteredNames); // Output: [Alice, Andrew, Amanda]

        // .MAP() METHOD
        List<String> upperCaseNames = names.stream()
                //.map(String::toUpperCase)
                .map(name-> name.toUpperCase())
                .collect(Collectors.toList());

        System.out.println(upperCaseNames); // Output: [ALICE, BOB, CHARLIE, DAVID, ANDREW, AMANDA]

        // .SORTED() METHOD
        List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 9);

        List<Integer> ascendingOrder = numbers.stream()
                .sorted()
                .collect(Collectors.toList());

        List<Integer> descendingOrder = numbers.stream()
                .sorted((a, b) -> b - a)
                .collect(Collectors.toList());

        System.out.println("Ascending: " + ascendingOrder);   // Output: [1, 3, 5, 8, 9]
        System.out.println("Descending: " + descendingOrder); // Output: [9, 8, 5, 3, 1]

        // REDUCING AND AGGREGATING
        List<Integer> numbers2 = Arrays.asList(10, 20, 30, 40, 50);

        int sum = numbers2.stream()
                .mapToInt(Integer::intValue)
                .sum();

        OptionalDouble average = numbers2.stream()
                .mapToInt(Integer::intValue)
                .average();

        System.out.println("Sum: " + sum);                   // Output: Sum: 150
        System.out.println("Average: " + average.getAsDouble()); // Output: Average: 30.0

        // COLLECTING TO OTHER COLLECTIONS
        List<Integer> numbers3 = Arrays.asList(2, 3, 4, 2, 3);

        Set<Integer> squares = numbers3.stream()
                .map(n -> n * n)
                .collect(Collectors.toSet());

        System.out.println(squares); // Output: [4, 9, 16]

        // .FOREACH()
        List<Integer> numbers4 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers4.stream()
                .filter(num -> num % 2 == 0)  // Filter even numbers
                //.forEach(num -> System.out.println(num));
                .forEach(System.out::println);  // Print each even number

        // LISTS OF LISTS AND FLATMAP
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9)
        );

        List<Integer> flattenedList = listOfLists.stream()
                .flatMap(List::stream)  // Flatten the lists into a single stream
                .collect(Collectors.toList());  // Collect into a single list

        System.out.println(flattenedList);

        ///
        List<String> sentences = Arrays.asList(
                "Hello world",
                "Java streams are powerful",
                "flatMap is useful"
        );

        List<String> words = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))  // Split sentences into words and flatten
                .collect(Collectors.toList());

        System.out.println(words);

        // Define the grades list
        List<Integer> grades = Arrays.asList(95, 75);  // Max grade = 95, Min grade = 75

        // Define a student with name, age, and grades
        List<Object> student = Arrays.asList("John Doe", 18, grades);

        // Retrieve the grades list from the student
        List<Integer> studentGrades = (List<Integer>) student.get(2);

        // Access and print the minimum grade
        int minGrade = studentGrades.get(1);
        System.out.println("Student's Minimum Grade: " + minGrade);

    }
}
