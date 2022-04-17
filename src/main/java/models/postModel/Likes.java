package models.postModel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "can_like",
        "count",
        "user_likes",
        "can_publish"
})

public class Likes {
    @JsonProperty("can_like")
    private Integer canLike;
    @JsonProperty("count")
    private Integer count;
    @JsonProperty("user_likes")
    private Integer userLikes;
    @JsonProperty("can_publish")
    private Integer canPublish;
}