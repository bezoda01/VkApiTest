package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class UploadUrlModel {
    private int album_id;
    private String upload_url;
    private int user_id;

    @SuppressWarnings("unchecked")
    @JsonProperty("response")
    private void unpackNested(Map responses) {
        this.album_id = (int) responses.get("album_id");
        this.upload_url = (String) responses.get("upload_url");
        this.user_id = (int) responses.get("user_id");
    }
}