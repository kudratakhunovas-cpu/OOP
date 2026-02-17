import java.util.*;

public class Main {
    public static void main(String[] args) {

        // 1.
        System.out.println("1. Create & Put");
        HashMap<String, Integer> studentScores = new HashMap<>();
        studentScores.put("Aida", 85);
        studentScores.put("Azat", 92);
        studentScores.put("Dana", 77);
        System.out.println("Map: " + studentScores);
        System.out.println("Size: " + studentScores.size());
        System.out.println();

        // 2.
        System.out.println("2. Get & ContainsKey");
        System.out.println("Aida's score: " + studentScores.get("Aida"));
        if (studentScores.containsKey("Mira")) {
            System.out.println("Mira's score: " + studentScores.get("Mira"));
        } else {
            System.out.println("Mira not found");
        }
        System.out.println();

        // 3.
        System.out.println("3. Update Existing Value");
        Integer oldDana = studentScores.put("Dana", 80);
        System.out.println("Old Dana's score: " + oldDana);
        System.out.println("Updated map: " + studentScores);
        System.out.println();

        // 4.
        System.out.println("4. Remove by Key");
        Integer removedAzat = studentScores.remove("Azat");
        System.out.println("Removed Azat: " + (removedAzat != null));
        Integer removedNonExisting = studentScores.remove("NonExisting");
        System.out.println("Removed NonExisting: " + (removedNonExisting != null));
        System.out.println("Map now: " + studentScores);
        System.out.println();

        // 5.
        System.out.println("5. isEmpty & clear");
        System.out.println("Is empty before clear? " + studentScores.isEmpty());
        studentScores.clear();
        System.out.println("Is empty after clear? " + studentScores.isEmpty());
        studentScores.put("Aida", 85);
        studentScores.put("Dana", 80);
        studentScores.put("Mira", 90);
        System.out.println();

        // 6.
        System.out.println("6. getOrDefault");
        int scoreMira = studentScores.getOrDefault("Mira", -1);
        System.out.println(scoreMira == -1 ? "Mira not found" : "Mira's score: " + scoreMira);
        int scoreAzat = studentScores.getOrDefault("Azat", -1);
        System.out.println(scoreAzat == -1 ? "Azat not found" : "Azat's score: " + scoreAzat);
        System.out.println();

        // 7.
        System.out.println("7. putIfAbsent");
        studentScores.putIfAbsent("Aida", 90);
        studentScores.putIfAbsent("Mira", 88);
        studentScores.putIfAbsent("NewStudent", 75);
        System.out.println(studentScores);
        System.out.println();

        // 8.
        System.out.println("8. replace");
        boolean replacedConditional = studentScores.replace("Aida", 85, 86);
        System.out.println("Conditional replace Aida: " + replacedConditional);
        studentScores.replace("Aida", 91);
        studentScores.replace("NonExisting", 100);
        System.out.println(studentScores);
        System.out.println();

        // 9.
        System.out.println("9. Iterate over keys, values, entries");
        System.out.println("Keys: " + studentScores.keySet());
        System.out.println("Values: " + studentScores.values());
        for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        System.out.println();

        // 10.
        System.out.println("10. Count scores >= 80");
        int count = 0;
        for (int val : studentScores.values()) {
            if (val >= 80) count++;
        }
        System.out.println("Count >= 80: " + count);
        System.out.println();

        // 11.
        System.out.println("11. Find max score");
        int maxScore = Integer.MIN_VALUE;
        ArrayList<String> topStudents = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
            if (entry.getValue() > maxScore) {
                maxScore = entry.getValue();
                topStudents.clear();
                topStudents.add(entry.getKey());
            } else if (entry.getValue() == maxScore) {
                topStudents.add(entry.getKey());
            }
        }
        System.out.println("Max score: " + maxScore + ", Students: " + topStudents);
        System.out.println();

        // 12.
        System.out.println("12. Word Frequency Counter");
        String text = "Java is fun and Java is powerful and fun";
        String[] words = text.toLowerCase().split(" ");
        HashMap<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        System.out.println(wordCount);
        System.out.println();

        // 13.
        System.out.println("13. Character Frequency");
        String str = "Mississippi";
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c : str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        System.out.println(charCount);
        char maxChar = ' ';
        int maxFreq = 0;
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                maxChar = entry.getKey();
            }
        }
        System.out.println("Most frequent char: " + maxChar);
        System.out.println();

        // 14.
        System.out.println("14. Group Words by Length");
        String[] arr = {"hi","book","java","sun","loop","map"};
        HashMap<Integer, ArrayList<String>> lengthMap = new HashMap<>();
        for (String word : arr) {
            lengthMap.computeIfAbsent(word.length(), k -> new ArrayList<>()).add(word);
        }
        System.out.println(lengthMap);
        System.out.println();

        // 15.
        System.out.println("15. First Non-Repeating Character");
        String test = "swiss";
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char c : test.toCharArray())
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);

        char firstNonRepeat = ' ';
        for (char c : test.toCharArray()) {
            if (freqMap.get(c) == 1) {
                firstNonRepeat = c;
                break;
            }
        }
        System.out.println(firstNonRepeat == ' ' ? "None" : firstNonRepeat);
        System.out.println();

        // 16.
        System.out.println("16. Two-Sum");
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (indexMap.containsKey(complement)) {
                System.out.println("Indices: [" + indexMap.get(complement) + ", " + i + "]");
            }
            indexMap.put(nums[i], i);
        }
        System.out.println();

        // 17.
        System.out.println("17. Detect Duplicates");
        String[] fruits = {"apple","banana","apple","orange","banana","kiwi"};
        HashMap<String, Integer> fruitCount = new HashMap<>();
        for (String f : fruits)
            fruitCount.put(f, fruitCount.getOrDefault(f, 0) + 1);

        System.out.println("Unique items:");
        for (String k : fruitCount.keySet())
            if (fruitCount.get(k) == 1)
                System.out.println(k);

        System.out.println("Duplicated items:");
        for (String k : fruitCount.keySet())
            if (fruitCount.get(k) > 1)
                System.out.println(k + "=" + fruitCount.get(k));
        System.out.println();

        // 18.
        System.out.println("18. Equals & Order-Insensitivity");
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);
        map2.put("B", 2);
        map2.put("A", 1);

        System.out.println("Maps equal? " + map1.equals(map2));
        System.out.println("HashCodes: " + map1.hashCode() + " & " + map2.hashCode());
        System.out.println();

        // 19.
        System.out.println("19. Remove Entries Conditionally");
        studentScores.put("LowStudent", 50);
        Iterator<Map.Entry<String, Integer>> it = studentScores.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue() < 60)
                it.remove();
        }
        System.out.println(studentScores);
        System.out.println();

        // 20.
        System.out.println("20. Merge scores");
        HashMap<String, Integer> scores1 = new HashMap<>();
        scores1.put("Aida", 40);
        scores1.put("Azat", 35);
        scores1.put("Dana", 50);

        HashMap<String, Integer> scores2 = new HashMap<>();
        scores2.put("Azat", 10);
        scores2.put("Dana", 5);
        scores2.put("Mira", 45);

        for (Map.Entry<String, Integer> e : scores2.entrySet()) {
            scores1.merge(e.getKey(), e.getValue(), Integer::sum);
        }
        System.out.println(scores1);
        System.out.println();

        // 21.
        System.out.println("21. Invert a Map");
        HashMap<String, Integer> studentMap = new HashMap<>();
        studentMap.put("Aida", 85);
        studentMap.put("Dana", 80);
        studentMap.put("Mira", 85);

        HashMap<Integer, ArrayList<String>> inverted = new HashMap<>();
        for (Map.Entry<String, Integer> e : studentMap.entrySet()) {
            inverted.computeIfAbsent(e.getValue(), k -> new ArrayList<>()).add(e.getKey());
        }
        System.out.println(inverted);
        System.out.println();

        // 22.
        System.out.println("22. Top-K Frequent Words");
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(wordCount.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        for (int i = 0; i < 2 && i < list.size(); i++) {
            System.out.println(list.get(i).getKey() + "=" + list.get(i).getValue());
        }
    }
}
