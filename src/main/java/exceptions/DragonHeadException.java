package exceptions;

public class DragonHeadException extends Exception{
    public DragonHeadException(Integer size) {
        super("Значение size не может быть null");
    }
}
