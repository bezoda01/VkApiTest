package models;

import lombok.Data;

@Data
public class ResponseModel {
    private String body;
    private int statusCode;

    public ResponseModel(String body, int statusCode) {
        this.body = body;
        this.statusCode = statusCode;
    }
}
