package be.pxl.ja.exercise;

public class WrongFoodException extends RuntimeException { //unchecked exception
    public WrongFoodException(String message) {
        super(message);
    }
}
