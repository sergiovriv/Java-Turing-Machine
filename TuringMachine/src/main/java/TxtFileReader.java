import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * The {@code TxtFileReader} class implements the {@code FileReaderInterface} and is responsible for reading
 * text (TXT) files to create a tape and populate a rule set.
 */
public class TxtFileReader implements FileReaderInterface {

    /**
     * Reads a text (TXT) file, initializes the head position, creates a tape, and populates a rule set
     * based on the data in the text file.
     *
     * @param filePath The path to the text (TXT) file to read.
     * @param head     The head object to initialize with the read head position.
     * @param ruleSet  The rule set to populate with rules from the text file.
     * @return A {@code Tape} object created from the text file data, or {@code null} if an error occurs.
     */
    @Override
    public Tape readFile(String filePath, Head head, RuleSet ruleSet) {
        Tape tape = null;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            if ((line = br.readLine()) != null) {
                head.setPosition(Integer.parseInt(line.trim()));
            }
            if ((line = br.readLine()) != null) {
                tape = new Tape(line.trim());
            }
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                Rule rule = new Rule(parts[0], parts[1].charAt(0), parts[2].charAt(0), parts[3].charAt(0), parts[4]);
                ruleSet.addRule(rule);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tape;
    }
}
