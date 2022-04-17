package models.postModel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "count",
        "items",
        "next_from"
})

public class Response {

    @JsonProperty("count")
    private Integer count;
    @JsonProperty("items")
    private List<Item> items = null;
    @JsonProperty("next_from")
    public String nextFrom;
}