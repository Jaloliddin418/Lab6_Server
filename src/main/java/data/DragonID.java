package data;

import java.io.Serializable;
import java.util.UUID;

public class DragonID implements Serializable {
    public static int getId() {
        return (int) UUID.randomUUID().getMostSignificantBits();
    }
}