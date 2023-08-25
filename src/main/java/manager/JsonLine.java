package manager;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


import java.io.Serializable;

public class JsonLine implements Serializable {
    private static final long serialVersionUID = 1234569L;
   private String jsonString;

    public String toJson() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        jsonString = mapper.writeValueAsString(this);
        return jsonString;
    }

    public MessageToSer fromJson(String json) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper.readValue(json, MessageToSer.class);
    }
}
