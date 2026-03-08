import java.util.*;

public class ProjectMain {

    static ArrayDeque<String> line = new ArrayDeque<>();
    static HashMap<String, Integer> arrivalTime = new HashMap<>();

    static int currentTime = 0;
    static int servedCount = 0;
    static long totalWait = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        printHelp();

        while (true) {

            System.out.print("> ");
            String command = sc.next();

            if (command.equalsIgnoreCase("HELP")) {
                printHelp();
            }

            else if (command.equalsIgnoreCase("ARRIVE")) {
                if (!sc.hasNext()) {
                    System.out.println("Usage: ARRIVE <name>");
                    continue;
                }
                String name = sc.next();
                arrive(name);
            }

            else if (command.equalsIgnoreCase("VIP_ARRIVE")) {
                if (!sc.hasNext()) {
                    System.out.println("Usage: VIP_ARRIVE <name>");
                    continue;
                }
                String name = sc.next();
                vipArrive(name);
            }

            else if (command.equalsIgnoreCase("SERVE")) {
                serve();
            }

            else if (command.equalsIgnoreCase("LEAVE")) {
                if (!sc.hasNext()) {
                    System.out.println("Usage: LEAVE <name>");
                    continue;
                }
                String name = sc.next();
                leave(name);
            }

            else if (command.equalsIgnoreCase("PEEK")) {
                peek();
            }

            else if (command.equalsIgnoreCase("SIZE")) {
                System.out.println("Size: " + line.size());
            }

            else if (command.equalsIgnoreCase("PRINT")) {
                System.out.println("Line (front -> back): " + line);
            }

            else if (command.equalsIgnoreCase("TICK")) {
                if (!sc.hasNextInt()) {
                    System.out.println("Usage: TICK <minutes>");
                    continue;
                }
                int minutes = sc.nextInt();
                tick(minutes);
            }

            else if (command.equalsIgnoreCase("STATS")) {
                stats();
            }

            else if (command.equalsIgnoreCase("EXIT")) {
                System.out.println("Goodbye!");
                break;
            }

            else {
                System.out.println("Unknown command. Type HELP.");
                sc.nextLine();
            }
        }

        sc.close();
    }

    static void arrive(String name) {

        if (arrivalTime.containsKey(name)) {
            System.out.println("Name already in system");
            return;
        }

        line.addLast(name);
        arrivalTime.put(name, currentTime);

        System.out.println(name + " arrived at time " + currentTime + ". Line size = " + line.size());
    }

    static void vipArrive(String name) {

        if (arrivalTime.containsKey(name)) {
            System.out.println("Name already in system");
            return;
        }

        line.addFirst(name);
        arrivalTime.put(name, currentTime);

        System.out.println("VIP " + name + " arrived at time " + currentTime + ". Line size = " + line.size());
    }

    static void serve() {

        if (line.isEmpty()) {
            System.out.println("No one to serve.");
            return;
        }

        String name = line.removeFirst();

        int arrival = arrivalTime.get(name);
        int wait = currentTime - arrival;

        servedCount++;
        totalWait += wait;

        arrivalTime.remove(name);

        System.out.println("Served: " + name + " (waited " + wait + " min).");
    }

    static void leave(String name) {

        if (!line.contains(name)) {
            System.out.println("Not found");
            return;
        }

        line.removeFirstOccurrence(name);
        arrivalTime.remove(name);

        System.out.println(name + " left the line. Line size = " + line.size());
    }

    static void peek() {

        if (line.isEmpty()) {
            System.out.println("Line is empty.");
            return;
        }

        System.out.println("Next: " + line.peekFirst());
    }

    static void tick(int minutes) {

        if (minutes < 0) {
            System.out.println("Minutes must be non-negative.");
            return;
        }

        currentTime += minutes;

        System.out.println("Time advanced by " + minutes + " minutes. Current time = " + currentTime);
    }

    static void stats() {

        if (servedCount == 0) {
            System.out.println("Served count = 0, Avg wait = 0.00 min.");
            return;
        }

        double avg = (double) totalWait / servedCount;

        System.out.printf("Served count = %d, Avg wait = %.2f min.%n", servedCount, avg);
    }

    static void printHelp() {

        System.out.println("Cafeteria Line Manager — Commands:");
        System.out.println("HELP");
        System.out.println("ARRIVE <name>");
        System.out.println("VIP_ARRIVE <name>");
        System.out.println("SERVE");
        System.out.println("LEAVE <name>");
        System.out.println("PEEK");
        System.out.println("SIZE");
        System.out.println("PRINT");
        System.out.println("TICK <minutes>");
        System.out.println("STATS");
        System.out.println("EXIT");
    }
}