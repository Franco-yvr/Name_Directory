package ca.ubc.cs.cpsc210.model.exceptions;

public class EmptyStringException extends Exception {

    public EmptyStringException(String msg) {
        super(msg);
    }
}

public class OutOfBoundException extends RuntimeException {

    public OutOfBoundException(int index) {
        super("The index " + Integer.toString(index) + " is smaller or larger than the list of size");
    }
}
