package response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


import java.io.Serializable;

public class ResponseToClient implements Serializable {
    private final long serialVersionUID = 844313218;
    private String jsonString;
    private String responseText;

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }
    public String toJson() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        jsonString = mapper.writeValueAsString(this);
        return jsonString;
    }
    public static ResponseToClient fromJson(String json) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper.readValue(json, ResponseToClient.class);
    }

    @Override
    public String toString() {
        return responseText;
    }
}