import java.util.Random;
import java.util.Scanner;

public class Guesser {
    private static final int MIN = 1;
    private static final int MAX = 100;
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("0) Exit");
            System.out.println("1) Human Guesser");
            System.out.println("2) Computer guesser");
            System.out.println();
            choice = readInt("Please enter 0-2: ", 0, 2);

            if (choice == 1) {
                humanGuesser();
            } else if (choice == 2) {
                computerGuesser();
            }
        } while (choice != 0);
    }

    private static void humanGuesser() {
        System.out.println("human guesser");
        int secret = new Random().nextInt(MAX - MIN + 1) + MIN;
       

        int tries = 0;
        while (true) {
            tries++;
            int guess = readInt(tries + ") Please enter a number: ", MIN, MAX);
            if (guess < secret) {
                System.out.println("Too low...");
            } else if (guess > secret) {
                System.out.println("Too high...");
            } else {
                System.out.println("Got it!");
                break;
            }
        }
        System.out.println();
        System.out.println("Very good!");
        System.out.println();
    }

    private static void computerGuesser() {
        System.out.println("computer guesser");
        int low = MIN;
        int high = MAX;
        int tries = 0;

        while (low <= high) {
            tries++;
            int guess = (low + high) / 2;
            System.out.println(tries + ") I guess " + guess);

            char answer = readAnswer("Too (H)igh, too (L)ow, or (C)orrect? ");
            if (answer == 'c') {
                System.out.println();
                return;
            } else if (answer == 'h') {
                high = guess - 1;
            } else {
                low = guess + 1;
            }
        }
        System.out.println("Contradiction detected.");
        System.out.println();
    }

    private static char readAnswer(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = in.nextLine();
            if (!line.isEmpty()) {
                char c = line.charAt(0);
                if (c == 'h' || c == 'l' || c == 'c') {
                    return c;
                }
            }
            System.out.println("Please enter h, l, or c.");
        }
    }

    private static int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String line = in.nextLine().trim();
            try {
                int value = Integer.parseInt(line);
                if (value >= min && value <= max) {
                    return value;
                }
            } catch (NumberFormatException ignored) { }
            System.out.println("Invalid input. Enter a number from " + min + " to " + max + ".");
        }
    }
}
