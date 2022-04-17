package models.postModel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "count",
        "wall_count",
        "mail_count",
        "user_reposted"
})

public class Reposts {

    @JsonProperty("count")
    private Integer count;
    @JsonProperty("wall_count")
    private Integer wallCount;
    @JsonProperty("mail_count")
    private Integer mailCount;
    @JsonProperty("user_reposted")
    private Integer userReposted;
}