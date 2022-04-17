package api;

public enum VkApi {
    WALL_POST("wall.post?owner_id=%s&message=%s%s"),
    WALL_GET("wall.get?owner_id=%s&post_id=%s&count=1%s"),
    WALL_DELETE("wall.delete?owner_id=%s&post_id=%s%s"),
    PHOTOS_GET_UPLOAD_SERVER("photos.getWallUploadServer?owner_id=%s%s"),
    PHOTOS_SAVE_WALL_PHOTO("photos.saveWallPhoto?user_id=%s&server=%s&photo=%s&hash=%s%s"),
    WALL_EDIT("wall.edit?owner_id=%s&post_id=%s&message=%s&attachments=photo%s_%s%s"),
    WALL_CREATE_COMMENT("wall.createComment?owner_id=%s&post_id=%s&message=%s%s");

    private final String value;

    VkApi(String value) {
        this.value  = value;
    }

    public String getValue() {
        return value;
    }
}
