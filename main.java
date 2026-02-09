import java.util.*;

public class main {
    public static void main(String[] args) {
        // 1.
        List<Integer> nums = Arrays.asList(1, 2, 2, 3, 4, 4, 4, 5);
        HashSet<Integer> uniqueNums = new HashSet<>(nums);
        System.out.println("1: " + uniqueNums);

        // 2.
        HashSet<String> allowedUsers = new HashSet<>(Arrays.asList("Alice", "Bob", "Charlie"));
        System.out.println("2: " + isAllowed(allowedUsers, "Bob"));
        System.out.println("2: " + isAllowed(allowedUsers, "David"));

        // 3.
        HashSet<Integer> setSize = new HashSet<>(Arrays.asList(10, 20, 30));
        System.out.println("3 size: " + setSize.size());
        setSize.clear();
        System.out.println("3 empty: " + setSize.isEmpty());

        // 4.
        HashSet<String> names = new HashSet<>(Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve"));
        boolean removed = names.remove("Charlie");
        System.out.println("4 removed: " + removed + ", set: " + names);

        // 5. 
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));
        set1.addAll(set2);
        System.out.println("5: " + set1);

        // 6.
        HashSet<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        HashSet<Integer> setB = new HashSet<>(Arrays.asList(2, 4));
        setA.removeAll(setB);
        System.out.println("6: " + setA);

        // 7.
        HashSet<Integer> setX = new HashSet<>(Arrays.asList(1, 2, 3));
        HashSet<Integer> setY = new HashSet<>(Arrays.asList(2, 3, 4));
        setX.retainAll(setY);
        System.out.println("7: " + setX);

        // 8.
        HashSet<Integer> setC = new HashSet<>(Arrays.asList(1, 2, 3));
        HashSet<Integer> setD = new HashSet<>(Arrays.asList(2, 3));
        System.out.println("8: " + (setC.containsAll(setD) ? "SetC contains all SetD elements" : "SetC does not contain all SetD elements"));

        // 9.
        String sentence = "apple banana apple orange banana";
        String[] words = sentence.split(" ");
        HashSet<String> uniqueWords = new HashSet<>(Arrays.asList(words));
        System.out.println("9: " + uniqueWords);

        // 10.
        String[] wordArr = {"Apple", "apple", "APPLE", "Banana"};
        HashSet<String> caseInsensitiveSet = new HashSet<>();
        for (String w : wordArr) caseInsensitiveSet.add(w.toLowerCase());
        System.out.println("10: " + caseInsensitiveSet);

        // 11.
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println("11 peek: " + queue.peek());
        while (!queue.isEmpty()) System.out.println("11 poll: " + queue.poll());

        // 12.
        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        while (!stack.isEmpty()) System.out.println("12 pop: " + stack.pop());

        // 13.
        ArrayDeque<Integer> deque1 = new ArrayDeque<>();
        deque1.addFirst(1);
        deque1.addLast(2);
        deque1.addFirst(0);
        System.out.println("13 deque: " + deque1);

        // 14.
        ArrayDeque<Integer> deque2 = new ArrayDeque<>();
        System.out.println("14 offerFirst: " + deque2.offerFirst(10));
        System.out.println("14 offerLast: " + deque2.offerLast(20));
        System.out.println("14 deque: " + deque2);

        // 15.
        ArrayDeque<Integer> deque3 = new ArrayDeque<>(Arrays.asList(1, 2, 3));
        System.out.println("15 peek: " + deque3.peek());
        System.out.println("15 peekFirst: " + deque3.peekFirst());
        System.out.println("15 peekLast: " + deque3.peekLast());
        ArrayDeque<Integer> emptyDeque = new ArrayDeque<>();
        System.out.println("15 peek empty: " + emptyDeque.peek());

        // 16.
        ArrayDeque<Integer> deque4 = new ArrayDeque<>(Arrays.asList(1, 2, 3));
        while (!deque4.isEmpty()) System.out.println("16 poll: " + deque4.poll());
        deque4 = new ArrayDeque<>(Arrays.asList(1, 2, 3));
        while (!deque4.isEmpty()) System.out.println("16 pollFirst: " + deque4.pollFirst());
        deque4 = new ArrayDeque<>(Arrays.asList(1, 2, 3));
        while (!deque4.isEmpty()) System.out.println("16 pollLast: " + deque4.pollLast());

        // 17.
        ArrayDeque<String> deque5 = new ArrayDeque<>(Arrays.asList("a","b","c","b","a"));
        deque5.removeFirstOccurrence("b");
        System.out.println("17 after removeFirstOccurrence: " + deque5);
        deque5.removeLastOccurrence("a");
        System.out.println("17 after removeLastOccurrence: " + deque5);

        // 18.
        ArrayDeque<Integer> deque6 = new ArrayDeque<>();
        deque6.add(1);
        System.out.println("18 size: " + deque6.size() + ", empty: " + deque6.isEmpty());
        deque6.remove();
        System.out.println("18 size: " + deque6.size() + ", empty: " + deque6.isEmpty());

        // 19.
        ArrayDeque<Integer> deque7 = new ArrayDeque<>(Arrays.asList(1,2,3));
        deque7.clear();
        System.out.println("19 peek: " + deque7.peek() + ", empty: " + deque7.isEmpty());

        // 20.
        String str = "radar";
        ArrayDeque<Character> deque8 = new ArrayDeque<>();
        for (char c : str.toCharArray()) deque8.add(c);
        boolean palindrome = true;
        while (deque8.size() > 1) if (!deque8.removeFirst().equals(deque8.removeLast())) palindrome = false;
        System.out.println("20 is palindrome: " + palindrome);

        // 21.
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.addTask("Normal1", false);
        scheduler.addTask("High1", true);
        scheduler.addTask("Normal2", false);
        scheduler.addTask("High2", true);
        System.out.println("21 process: " + scheduler.processTask());
        System.out.println("21 process: " + scheduler.processTask());
        System.out.println("21 process: " + scheduler.processTask());
        System.out.println("21 process: " + scheduler.processTask());
    }

    static boolean isAllowed(HashSet<String> set, String name) {
        return set.contains(name);
    }
}

class TaskScheduler {
    private ArrayDeque<String> tasks = new ArrayDeque<>();

    void addTask(String task, boolean highPriority) {
        if (highPriority) tasks.addFirst(task);
        else tasks.addLast(task);
    }

    String processTask() {
        return tasks.pollFirst();
    }
}
