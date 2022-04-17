package models.postModel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "can_post",
        "can_close",
        "count",
        "groups_can_post"
})

public class Comments {
    @JsonProperty("can_post")
    private Integer canPost;
    @JsonProperty("can_close")
    private Integer canClose;
    @JsonProperty("count")
    private Integer count;
    @JsonProperty("groups_can_post")
    private Boolean groupsCanPost;
}