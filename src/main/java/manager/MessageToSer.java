package manager;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import data.Dragon;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;

public class MessageToSer implements Serializable {
    @Serial
    private static final long serialVersionUID = 1234566L;
    private String message;
    private String []arg;
    private Dragon dragon;
    private String jsonString;


    public MessageToSer(){}

    public MessageToSer(String message, String []arg) {
        this.arg = arg;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String []getArg() {
        return arg;
    }

    public void setArg(String[] arg) {
        this.arg = arg;
    }

    public Dragon getDragon() {
        return dragon;
    }

    public void setDragon(Dragon dragon) {
        this.dragon = dragon;
    }

    public String toJson() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        jsonString = mapper.writeValueAsString(this);
        return jsonString;
    }
    public static MessageToSer fromJson(String json) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper.readValue(json, MessageToSer.class);
    }


    @Override
    public String toString() {
        return "MessageToSer{" +
                "message = '" + message + '\'' +
//                ", arg = " + Arrays.toString(arg) +
                ", dragon = " + dragon +
                '}';
    }
}