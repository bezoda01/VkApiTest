package models;

import lombok.Data;

@Data
public class PostPhotoModel {
    private int server;
    private String photo;
    private String hash;
}
