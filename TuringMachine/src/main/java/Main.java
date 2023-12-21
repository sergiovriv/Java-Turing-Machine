import java.util.Scanner;

/**
 * The {@code Main} class represents the entry point of the Turing Machine simulation program.
 */
public class Main {
    /**
     * The main method of the program, responsible for reading a file, setting up the Turing Machine,
     * and executing it.
     *
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the file name (including extension):");
        String filePath = scanner.nextLine();

        Head head = new Head(0);
        RuleSet ruleSet = new RuleSet();

        FileReaderInterface fileReader;
        Tape tape;

        if (filePath.endsWith(".txt")) {
            fileReader = new TxtFileReader();
        } else if (filePath.endsWith(".json")) {
            fileReader = new JsonFileReader();
        } else {
            scanner.close();
            throw new IllegalArgumentException("Unsupported file format");
        }

        tape = fileReader.readFile(filePath, head, ruleSet);

        // Create a StateMachine and execute it
        StateMachine machine = new StateMachine(tape, head, ruleSet, "0");
        machine.execute();

        scanner.close(); // Close the scanner
    }
}
