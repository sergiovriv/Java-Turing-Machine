import java.util.ArrayList;
import java.util.List;

/**
 * The {@code RuleSet} class represents a collection of transition rules for a Turing Machine.
 */
public class RuleSet {
    private List<Rule> rules;

    /**
     * Constructs a new empty rule set.
     */
    public RuleSet() {
        this.rules = new ArrayList<>();
    }

    /**
     * Adds a rule to the rule set.
     *
     * @param rule The rule to add to the rule set.
     */
    public void addRule(Rule rule) {
        rules.add(rule);
    }

    /**
     * Finds and returns an applicable rule based on the current state and read symbol.
     *
     * @param currentState The current state of the Turing Machine.
     * @param readSymbol   The symbol read from the tape.
     * @return An applicable rule if found, or {@code null} if no rule matches the current state and read symbol.
     */
    public Rule getApplicableRule(String currentState, char readSymbol) {
        for (Rule rule : rules) {
            if (rule.getCurrentState().equals(currentState) && rule.getReadSymbol() == readSymbol) {
                return rule;
            }
        }
        return null;
    }
}
