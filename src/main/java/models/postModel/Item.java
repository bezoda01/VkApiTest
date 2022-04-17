package models.postModel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "from_id",
        "owner_id",
        "date",
        "post_type",
        "text",
        "can_edit",
        "can_delete",
        "can_pin",
        "can_archive",
        "is_archived",
        "attachments",
        "post_source",
        "comments",
        "likes",
        "reposts",
        "is_favorite",
        "donut",
        "short_text_rate",
        "edited",
        "hash"
})

public class Item {

    @JsonProperty("id")
    public Integer id;
    @JsonProperty("from_id")
    public Integer fromId;
    @JsonProperty("owner_id")
    public Integer ownerId;
    @JsonProperty("date")
    public Integer date;
    @JsonProperty("type")
    public String type;
    @JsonProperty("can_delete")
    public Integer canDelete;
    @JsonProperty("is_favorite")
    public Boolean isFavorite;
    @JsonProperty("post_type")
    public String postType;
    @JsonProperty("text")
    public String text;
    @JsonProperty("can_edit")
    public Integer canEdit;
    @JsonProperty("can_pin")
    public Integer canPin;
    @JsonProperty("can_archive")
    public Boolean canArchive;
    @JsonProperty("is_archived")
    public Boolean isArchived;
    @JsonProperty("attachments")
    public List<Attachment> attachments = null;
    @JsonProperty("post_source")
    public PostSource postSource;
    @JsonProperty("comments")
    public Comments comments;
    @JsonProperty("likes")
    public Likes likes;
    @JsonProperty("reposts")
    public Reposts reposts;
    @JsonProperty("donut")
    public Donut donut;
    @JsonProperty("short_text_rate")
    public Float shortTextRate;
    @JsonProperty("edited")
    public Integer edited;
    @JsonProperty("hash")
    public String hash;
}