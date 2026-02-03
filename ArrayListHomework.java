package arraylist;

import java.util.*;

public class ArrayListHomework {

    public static void main(String[] args) {

        // 1.
        ArrayList<String> books1 = new ArrayList<>(Arrays.asList("Harry Potter", "1984", "Hamlet"));
        ArrayList<String> books2 = new ArrayList<>(Arrays.asList("Hamlet", "The Hobbit", "1984"));
        Set<String> mergedBooks = new HashSet<>(books1);
        mergedBooks.addAll(books2);
        System.out.println("1. Unique books: " + mergedBooks);

        // 2.
        ArrayList<String> movies = new ArrayList<>(Arrays.asList("Avatar", "Titanic", "Interstellar"));
        String longestMovie = movies.get(0);
        for (String m : movies) {
            if (m.length() > longestMovie.length()) {
                longestMovie = m;
            }
        }
        System.out.println("2. Longest movie title: " + longestMovie);

        // 3.
        ArrayList<String> foods = new ArrayList<>(Arrays.asList("Pizza", "Burger", "Pizza", "Pasta"));
        int pizzaCount = 0;
        for (String f : foods) {
            if (f.equals("Pizza")) {
                pizzaCount++;
            }
        }
        System.out.println("3. Pizza count: " + pizzaCount);

        // 4.
        ArrayList<String> fruits = new ArrayList<>(Arrays.asList("Banana", "Apple", "Banana", "Orange"));
        fruits.removeIf(f -> f.equals("Banana"));
        System.out.println("4. Fruits without Banana: " + fruits);

        // 5.
        ArrayList<String> colors = new ArrayList<>(Arrays.asList("Red", "Blue", "Green"));
        Collections.fill(colors, "Black");
        System.out.println("5. Colors replaced: " + colors);

        // 6.
        ArrayList<String> sports = new ArrayList<>(Arrays.asList("Football", "Basketball", "Tennis"));
        ArrayList<String> subSports = new ArrayList<>(Arrays.asList("Football", "Tennis"));
        System.out.println("6. Contains sublist: " + sports.containsAll(subSports));

        // 7.
        ArrayList<String> flowers = new ArrayList<>(Arrays.asList("Rose", "Lily", "Rose", "Tulip"));
        System.out.println("7. First index: " + flowers.indexOf("Rose"));
        System.out.println("   Last index: " + flowers.lastIndexOf("Rose"));

        // 8.
        ArrayList<String> animals = new ArrayList<>(Arrays.asList("Cat", "Dog", "Cat", "Horse"));
        ArrayList<String> uniqueAnimals = new ArrayList<>(new HashSet<>(animals));
        System.out.println("8. Unique animals: " + uniqueAnimals);

        // 9.
        ArrayList<String> cities = new ArrayList<>(Arrays.asList("Paris", "London", "Rome"));
        String[] cityArray = cities.toArray(new String[0]);
        System.out.println("9. Cities array: " + Arrays.toString(cityArray));

        // 10.
        Integer[] numbers = {1, 2, 3, 4};
        ArrayList<Integer> numberList = new ArrayList<>(Arrays.asList(numbers));
        System.out.println("10. Number ArrayList: " + numberList);

        // 11.
        ArrayList<String> countries1 = new ArrayList<>(Arrays.asList("USA", "France", "Italy"));
        ArrayList<String> countries2 = new ArrayList<>(Arrays.asList("Germany", "France", "Italy"));
        countries1.retainAll(countries2);
        System.out.println("11. Common countries: " + countries1);

        // 12.
        ArrayList<String> names = new ArrayList<>(Arrays.asList("Anna", "Mark", "John", "Eve"));
        names.removeIf(n -> n.length() % 2 == 0);
        System.out.println("12. Names with odd length: " + names);

        // 13.
        ArrayList<String> songs = new ArrayList<>(Arrays.asList("Hello", "Sky", "Dream"));
        String shortestSong = songs.get(0);
        for (String s : songs) {
            if (s.length() < shortestSong.length()) {
                shortestSong = s;
            }
        }
        System.out.println("13. Shortest song: " + shortestSong);

        // 14.
        ArrayList<String> words = new ArrayList<>(Arrays.asList("Apple", "Orange"));
        for (int i = 0; i < words.size(); i++) {
            words.set(i, words.get(i).replaceAll("[AEIOUaeiou]", "*"));
        }
        System.out.println("14. Words without vowels: " + words);

        // 15.
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();
        for (int n : nums) {
            if (n % 2 == 0) even.add(n);
            else odd.add(n);
        }
        System.out.println("15. Even: " + even + ", Odd: " + odd);

        // 16.
        ArrayList<String> days = new ArrayList<>(Arrays.asList("Mon", "Tue", "Wed", "Thu", "Fri"));
        Collections.rotate(days, 2);
        System.out.println("16. Rotated days: " + days);

        // 17.
        ArrayList<String> students = new ArrayList<>(Arrays.asList("Ali", null, "Sara", null));
        students.removeIf(Objects::isNull);
        System.out.println("17. Students without null: " + students);

        // 18.
        ArrayList<String> movieTitles = new ArrayList<>(Arrays.asList("Up", "Avatar", "Interstellar"));
        movieTitles.sort(Comparator.comparingInt(String::length).reversed());
        System.out.println("18. Second longest movie: " + movieTitles.get(1));

        // 19.
        ArrayList<String> fruitNames = new ArrayList<>(Arrays.asList("Apple", "Banana"));
        ArrayList<Integer> lengths = new ArrayList<>();
        for (String f : fruitNames) {
            lengths.add(f.length());
        }
        System.out.println("19. Fruit lengths: " + lengths);

        // 20.
        ArrayList<ArrayList<String>> departments = new ArrayList<>();
        departments.add(new ArrayList<>(Arrays.asList("Ali", "Sara")));
        departments.add(new ArrayList<>(Arrays.asList("gulchapchap", "Emma")));
        System.out.println("20. Departments: " + departments);
    }
}
