package observer;


import java.util.Stack;

/*
Use the class you've implemented in previous assignment
 */
public class UndoableStringBuilder {


    /**
     * This class is like the standard StringBuilder with support undo operation.
     * @author Shachar Ketz
     * @author Matan Aviv
     */
    //fields
    private StringBuilder sb;
    private Stack<StringBuilder> undoStack;

    //constructors:

    /**
     * Default constructor.
     */
    public UndoableStringBuilder() {
        this.sb = new StringBuilder();
        undoStack = new Stack<StringBuilder>();
    }

    //functions:

    /**
     * Appends the specified string to this character sequence. If str is null, then the four characters "null" are appends to this sequence.
     *
     * @param str A string.
     * @return A reference to this object.
     */
    public UndoableStringBuilder append(String str) {
        StringBuilder temp = new StringBuilder(sb);

        this.undoStack.push(temp);
        this.sb.append(str);

        return this;
    }

    /**
     * Removes the characters in a substring of this sequence.
     * The substring begins at the specified start and extends to the character at index end - 1 or to the end of the sequence if no such character exists.
     * If start is equal to end, no changes are made.
     *
     * @param start The beginning index, inclusive.
     * @param end   The ending index, exclusive.
     * @return This object.
     * @throws StringIndexOutOfBoundsException - if start is negative, greater than length(), or greater than end.
     */
    public UndoableStringBuilder delete(int start, int end) {
        StringBuilder temp = new StringBuilder(sb);
        try {
            this.undoStack.push(temp);
            this.sb.delete(start, end);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("the index are illegal!");
        }
        return this;
    }

    /**
     * Inserts the string into this character sequence.
     * The characters of the String argument are inserted, in order, into this sequence at the indicated offset, moving up any characters originally above that position and increasing the length of this sequence by the length of the argument.
     * If str is null, then the four characters "null" are inserted into this sequence.
     * The offset argument must be greater than or equal to 0, and less than or equal to the length of this sequence.
     *
     * @param offset the offset.
     * @param str    a string.
     * @return a reference to this object.
     * @throws StringIndexOutOfBoundsException - if the offset is invalid.
     */
    public UndoableStringBuilder insert(int offset, String str) {
        StringBuilder temp = new StringBuilder(sb);
        try {
            this.undoStack.push(temp);
            this.sb.insert(offset, str);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("the index are out of bounds!");
            System.out.println(e);
        }
        return this;
    }

    /**
     * Replaces the characters in a substring of this sequence with characters in the specified String.
     * The substring begins at the specified start and extends to the character at index end - 1 or to the end of the sequence if no such character exists.
     * First the characters in the substring are removed and then the specified String is inserted at start.
     * (This sequence will be lengthened to accommodate the specified String if necessary.)
     *
     * @param start The beginning index, inclusive.
     * @param end   The ending index, exclusive.
     * @param str   String that will replace previous contents.
     * @return This object.
     * @throws StringIndexOutOfBoundsException - if start is negative, greater than length(), or greater than end.
     */
    public UndoableStringBuilder replace(int start, int end, String str) {
        StringBuilder temp = new StringBuilder(sb);

        try {
            this.undoStack.push(temp);
            this.sb.replace(start, end, str);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("the index are illegal!");
            System.out.println(e);
        } catch (NullPointerException e) {
            System.out.println("str is null!");
            System.out.println(e);
        }
        return this;

    }

    /**
     * Causes this character sequence to be replaced by the reverse of the
     * sequence.
     *
     * @return a reference to this object.
     */
    public UndoableStringBuilder reverse() {

        StringBuilder temp = new StringBuilder(sb);
        this.undoStack.push(temp);
        this.sb.reverse();

        return this;
    }

    /**
     * Replace the sequence with the last copy sequence before the last used method,not include undo himself.
     * If non method had used, the sequence will be empty ("").
     *
     */
    public void undo() {
        if (undoStack.isEmpty()) {
            return;
        }
        this.sb = this.undoStack.pop();


    }

    /**
     * @return Returns a string representing the data in this sequence.
     */
    public String toString() {
        return sb.toString();
    }

}

