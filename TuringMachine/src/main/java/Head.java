/**
 * The {@code Head} class represents a simple head with a position in a one-dimensional space.
 */
public class Head {
    private int position;

    /**
     * Constructs a new {@code Head} object with the specified initial position.
     *
     * @param position The initial position of the head.
     */
    public Head(int position) {
        this.position = position;
    }

    /**
     * Moves the head one unit to the left.
     */
    public void moveLeft() {
        position--;
    }

    /**
     * Moves the head one unit to the right.
     */
    public void moveRight() {
        position++;
    }

    /**
     * Gets the current position of the head.
     *
     * @return The current position of the head.
     */
    public int getPosition() {
        return position;
    }

    /**
     * Sets the position of the head to the specified value.
     *
     * @param position The new position of the head.
     */
    public void setPosition(int position) {
        this.position = position;
    }
}
