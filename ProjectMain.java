import java.util.*;

public class ProjectMain {

    // queue (front = next to serve)
    static ArrayDeque<String> line = new ArrayDeque<>();

    // arrival time for each person
    static HashMap<String, Integer> arrivalTime = new HashMap<>();

    // logical time
    static int currentTime = 0;

    // statistics
    static long totalWait = 0;
    static int servedCount = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        printHelp();

        while (true) {

            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Invalid command.");
                continue;
            }

            String[] parts = input.split("\\s+");
            String command = parts[0].toUpperCase();

            switch (command) {

                case "HELP":
                    printHelp();
                    break;

                case "ARRIVE":
                    if (parts.length < 2) {
                        System.out.println("Usage: ARRIVE <name>");
                    } else {
                        arrive(parts[1]);
                    }
                    break;

                case "VIP_ARRIVE":
                    if (parts.length < 2) {
                        System.out.println("Usage: VIP_ARRIVE <name>");
                    } else {
                        vipArrive(parts[1]);
                    }
                    break;

                case "SERVE":
                    serve();
                    break;

                case "LEAVE":
                    if (parts.length < 2) {
                        System.out.println("Usage: LEAVE <name>");
                    } else {
                        leave(parts[1]);
                    }
                    break;

                case "PEEK":
                    peek();
                    break;

                case "SIZE":
                    size();
                    break;

                case "PRINT":
                    printLine();
                    break;

                case "TICK":
                    if (parts.length < 2) {
                        System.out.println("Usage: TICK <minutes>");
                    } else {
                        tick(parts[1]);
                    }
                    break;

                case "STATS":
                    stats();
                    break;

                case "EXIT":
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Unknown command. Type HELP.");
            }
        }
    }

    // print help menu
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

    // validate name
    static boolean validName(String name) {
        return name != null && !name.isEmpty() && !name.contains(" ");
    }

    // check duplicate
    static boolean exists(String name) {
        return arrivalTime.containsKey(name);
    }

    // arrive command
    static void arrive(String name) {

        if (!validName(name)) {
            System.out.println("Invalid name.");
            return;
        }

        if (exists(name)) {
            System.out.println("Name already in system");
            return;
        }

        line.addLast(name);
        arrivalTime.put(name, currentTime);

        System.out.println(name + " arrived at time " + currentTime +
                ". Line size = " + line.size());
    }

    // vip_arrive command
    static void vipArrive(String name) {

        if (!validName(name)) {
            System.out.println("Invalid name.");
            return;
        }

        if (exists(name)) {
            System.out.println("Name already in system");
            return;
        }

        line.addFirst(name);
        arrivalTime.put(name, currentTime);

        System.out.println("VIP " + name + " arrived at time " +
                currentTime + " (front). Line size = " + line.size());
    }

    // serve command
    static void serve() {

        if (line.isEmpty()) {
            System.out.println("No one to serve.");
            return;
        }

        String person = line.removeFirst();
        int arrival = arrivalTime.get(person);

        int wait = currentTime - arrival;

        totalWait += wait;
        servedCount++;

        arrivalTime.remove(person);

        System.out.println("Served: " + person +
                " (waited " + wait + " min).");
    }

    // leave command
    static void leave(String name) {

        if (!line.removeFirstOccurrence(name)) {
            System.out.println("Not found");
            return;
        }

        arrivalTime.remove(name);

        System.out.println(name +
                " left the line voluntarily. Line size = " +
                line.size());
    }

    // peek command
    static void peek() {

        if (line.isEmpty()) {
            System.out.println("Line is empty.");
            return;
        }

        System.out.println("Next: " + line.peekFirst());
    }

    // size command
    static void size() {
        System.out.println("Size: " + line.size());
    }

    // print command
    static void printLine() {
        System.out.println("Line (front -> back): " + line);
    }

    // tick command
    static void tick(String value) {

        try {

            int minutes = Integer.parseInt(value);

            if (minutes < 0) {
                System.out.println("Minutes must be >= 0.");
                return;
            }

            currentTime += minutes;

            System.out.println("Time advanced by " + minutes +
                    " minutes. Current time = " + currentTime);

        } catch (NumberFormatException e) {
            System.out.println("Invalid number.");
        }
    }

    // stats command
    static void stats() {

        double avg = 0.0;

        if (servedCount > 0) {
            avg = (double) totalWait / servedCount;
        }

        System.out.printf(
                "Served count = %d, Avg wait = %.2f min.%n",
                servedCount,
                avg
        );
    }
}