package exceptions;

public class CoordinatesException extends Exception{
    public CoordinatesException(int x) {
        super("Значение x не больше 123, текущее значение x " + x);
    }
    public CoordinatesException(long y) {
        super("Значение y не больше 173, текущее значение y " + y);
    }

}
