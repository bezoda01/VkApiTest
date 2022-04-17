package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class PostSendModel {
    private int response;

    @SuppressWarnings("unchecked")
    @JsonProperty("response")
    private void unpackNested(Map responses) {
        this.response = (int) responses.get("post_id");
    }
}
