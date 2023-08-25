package data;

import exceptions.DragonHeadException;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class DragonHead implements Serializable {
    private static final long serialVersionUID = 12343231;
    private Integer size; //Поле не может быть null
    private float toothCount;

    public DragonHead() {
    }

    public DragonHead(Integer size, float toothCount) throws DragonHeadException {
        if(size == null)
            throw new DragonHeadException(null);
        this.size = size;
        this.toothCount = toothCount;
    }

    @Override
    public String toString() {
        return "DragonHead{" +
                "size=" + size +
                ", toothCount=" + toothCount +
                '}';
    }
}
