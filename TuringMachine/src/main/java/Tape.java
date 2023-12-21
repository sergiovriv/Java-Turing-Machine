/**
 * The {@code Tape} class represents the tape of a Turing Machine.
 */
public class Tape {
    private char[] tape;

    /**
     * Constructs a new tape with the contents initialized from the given string.
     *
     * @param tapeString The string containing the initial tape contents.
     */
    public Tape(String tapeString) {
        this.tape = tapeString.toCharArray();
    }

    /**
     * Gets the symbol at the specified position on the tape.
     *
     * @param position The position to retrieve the symbol from.
     * @return The symbol at the specified position.
     */
    public char getSymbolAt(int position) {
        return tape[position];
    }

    /**
     * Sets the symbol at the specified position on the tape.
     *
     * @param position The position to set the symbol at.
     * @param symbol   The symbol to set at the specified position.
     */
    public void setSymbolAt(int position, char symbol) {
        tape[position] = symbol;
    }

    /**
     * Converts the tape contents to a string representation.
     *
     * @return A string representing the current tape contents.
     */
    @Override
    public String toString() {
        return new String(tape);
    }
}
