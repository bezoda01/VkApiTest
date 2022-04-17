package models.postModel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "platform",
        "type"
})

public class PostSource {

    @JsonProperty("platform")
    public String platform;
    @JsonProperty("type")
    private String type;
}