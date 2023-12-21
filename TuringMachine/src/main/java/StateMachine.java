/**
 * The {@code StateMachine} class represents a Turing Machine that executes a set of rules on a tape.
 */
public class StateMachine {
    private Tape tape;
    private Head head;
    private RuleSet ruleSet;
    private String currentState;

    /**
     * Constructs a new Turing Machine with the specified initial tape, head, rule set, and initial state.
     *
     * @param tape          The tape to operate on.
     * @param head          The head that reads and writes symbols on the tape.
     * @param ruleSet       The set of transition rules for the Turing Machine.
     * @param initialState  The initial state of the Turing Machine.
     */
    public StateMachine(Tape tape, Head head, RuleSet ruleSet, String initialState) {
        this.tape = tape;
        this.head = head;
        this.ruleSet = ruleSet;
        this.currentState = initialState;
    }

    /**
     * Executes the Turing Machine until it reaches a halting state (no applicable rule).
     * The machine reads symbols from the tape, applies rules, and updates the tape, head, and current state.
     * The execution continues until no applicable rule is found.
     */
    public void execute() {
        while (true) {
            char currentSymbol = tape.getSymbolAt(head.getPosition());
            Rule rule = ruleSet.getApplicableRule(currentState, currentSymbol);
            if (rule != null) {
                tape.setSymbolAt(head.getPosition(), rule.getWriteSymbol());
                if (rule.getMoveDirection() == 'L') {
                    head.moveLeft();
                } else {
                    head.moveRight();
                }
                currentState = rule.getNextState();
                System.out.println(tape);
            } else {
                break;
            }
        }
    }
}
