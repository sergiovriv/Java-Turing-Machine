/**
 * The {@code FileReaderInterface} interface defines a contract for reading files and creating a {@code Tape} object.
 */
public interface FileReaderInterface {
    /**
     * Reads a file specified by the given file path, initializes the head and rule set, and returns a tape.
     *
     * @param filePath The path to the file to be read.
     * @param head     The head object to be initialized.
     * @param ruleSet  The rule set to be populated with rules.
     * @return A {@code Tape} object created based on the file contents, or {@code null} if an error occurs.
     */
    Tape readFile(String filePath, Head head, RuleSet ruleSet);
}
