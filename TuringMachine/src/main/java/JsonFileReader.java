import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

/**
 * The {@code JsonFileReader} class implements the {@code FileReaderInterface}
 * and is responsible for reading JSON files to create a tape and populate a rule set.
 */
public class JsonFileReader implements FileReaderInterface {

    /**
     * Reads a JSON file, initializes the head position, creates a tape, and populates a rule set
     * based on the data in the JSON file.
     *
     * @param filePath The path to the JSON file to read.
     * @param head     The head object to initialize with the read head position.
     * @param ruleSet  The rule set to populate with rules from the JSON file.
     * @return A {@code Tape} object created from the JSON file data, or {@code null} if an error occurs.
     */
    @Override
    public Tape readFile(String filePath, Head head, RuleSet ruleSet) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode rootNode = mapper.readTree(new File(filePath));

            int headPosition = rootNode.path("head-start-position").asInt();
            head.setPosition(headPosition);

            String tapeString = rootNode.path("tape").asText();
            Tape tape = new Tape(tapeString);

            JsonNode rulesNode = rootNode.path("rules");
            if (rulesNode.isArray()) {
                for (JsonNode ruleNode : rulesNode) {
                    String state = ruleNode.path("state").asText();
                    char read = ruleNode.path("read").asText().charAt(0);
                    char write = ruleNode.path("write").asText().charAt(0);
                    char move = ruleNode.path("move").asText().charAt(0);
                    String nextState = ruleNode.path("next-state").asText();
                    ruleSet.addRule(new Rule(state, read, write, move, nextState));
                }
            }

            return tape;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
