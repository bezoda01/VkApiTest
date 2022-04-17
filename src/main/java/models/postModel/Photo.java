package models.postModel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "album_id",
        "date",
        "id",
        "owner_id",
        "access_key",
        "sizes",
        "text",
        "has_tags"
})

public class Photo {

    @JsonProperty("album_id")
    private Integer albumId;
    @JsonProperty("date")
    private Integer date;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("owner_id")
    private Integer ownerId;
    @JsonProperty("access_key")
    private String accessKey;
    @JsonProperty("sizes")
    private List<Size> sizes = null;
    @JsonProperty("text")
    private String text;
    @JsonProperty("has_tags")
    private Boolean hasTags;
}