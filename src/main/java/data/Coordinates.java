package data;

import exceptions.CoordinatesException;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter

public class Coordinates implements Serializable {
    private static final long serialVersionUID = 123432312;
    private int x; //Максимальное значение поля: 123
    private long y; //Максимальное значение поля: 173

    public Coordinates() {
    }

    public Coordinates(int x, long y)throws CoordinatesException{
        if(x>123)
            throw new CoordinatesException(x);
        if(y>173)
            throw new CoordinatesException(y);
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
