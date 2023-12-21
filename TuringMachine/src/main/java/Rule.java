/**
 * The {@code Rule} class represents a transition rule in a Turing Machine.
 */
public class Rule {
    private String currentState, nextState;
    private char readSymbol, writeSymbol, moveDirection;

    /**
     * Constructs a new rule with the specified parameters.
     *
     * @param currentState   The current state of the Turing Machine.
     * @param readSymbol     The symbol to be read on the tape.
     * @param writeSymbol    The symbol to be written on the tape.
     * @param moveDirection  The direction in which the tape head should move ('L' for left, 'R' for right).
     * @param nextState      The next state to transition to.
     */
    public Rule(String currentState, char readSymbol, char writeSymbol, char moveDirection, String nextState) {
        this.currentState = currentState;
        this.readSymbol = readSymbol;
        this.writeSymbol = writeSymbol;
        this.moveDirection = moveDirection;
        this.nextState = nextState;
    }

    /**
     * Gets the current state of the rule.
     *
     * @return The current state.
     */
    public String getCurrentState() {
        return currentState;
    }

    /**
     * Gets the next state to transition to.
     *
     * @return The next state.
     */
    public String getNextState() {
        return nextState;
    }

    /**
     * Gets the symbol to be read on the tape.
     *
     * @return The read symbol.
     */
    public char getReadSymbol() {
        return readSymbol;
    }

    /**
     * Gets the symbol to be written on the tape.
     *
     * @return The write symbol.
     */
    public char getWriteSymbol() {
        return writeSymbol;
    }

    /**
     * Gets the direction in which the tape head should move.
     *
     * @return The move direction ('L' for left, 'R' for right).
     */
    public char getMoveDirection() {
        return moveDirection;
    }
}
