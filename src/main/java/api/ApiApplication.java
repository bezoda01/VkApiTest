package api;

import models.PostPhotoModel;
import models.PostSendModel;
import models.ResponseModel;
import models.UploadUrlModel;
import models.postModel.PostMessageModel;
import models.requestPhotoModel.RequestPhotoModel;
import utils.APIUtils;
import utils.JsonUtils;

import java.net.URLEncoder;

public class ApiApplication {

    public static PostSendModel publishPost(String userId, String message) {
        ResponseModel responseModel = APIUtils.getRequest(String.format(VkApi.WALL_POST.getValue(),
                userId,
                message,
                Constants.TOKEN_AND_API_VERSION));
        return JsonUtils.jsonStringToObject(responseModel.getBody(), PostSendModel.class);
    }

    public static PostMessageModel getPostById(String userId, int post_id) {
        ResponseModel responseModel = APIUtils.getRequest(String.format(VkApi.WALL_GET.getValue(),
                userId,
                post_id,
                Constants.TOKEN_AND_API_VERSION));
        return JsonUtils.jsonStringToObject(responseModel.getBody(), PostMessageModel.class);
    }

    public static boolean deletePostById(String userId, int post_id) {
        ResponseModel responseModel = APIUtils.getRequest(String.format(VkApi.WALL_DELETE.getValue(),
                userId,
                post_id,
                Constants.TOKEN_AND_API_VERSION));
        return responseModel.getBody().contains("1");
    }

    public static UploadUrlModel getUploadUrl(String userId) {
        ResponseModel responseModel = APIUtils.getRequest(String.format(VkApi.PHOTOS_GET_UPLOAD_SERVER.getValue(),
                userId,
                Constants.TOKEN_AND_API_VERSION));
        return JsonUtils.jsonStringToObject(responseModel.getBody(), UploadUrlModel.class);
    }

    public static PostPhotoModel getPhotoAttribute(String inquiry) {
        ResponseModel responseModel = APIUtils.postUploadFile(inquiry, "photo", Constants.environment.getConfig().getApi().getFilePath());
        return JsonUtils.jsonStringToObject(responseModel.getBody(), PostPhotoModel.class);
    }

    public static RequestPhotoModel savePhotoInAlbum(String userId, PostPhotoModel postPhotoModel) {
        ResponseModel responseModel = APIUtils.getRequest(String.format(VkApi.PHOTOS_SAVE_WALL_PHOTO.getValue(),
                userId,
                postPhotoModel.getServer(),
                URLEncoder.encode(postPhotoModel.getPhoto()),
                postPhotoModel.getHash(),
                Constants.TOKEN_AND_API_VERSION));
        return JsonUtils.jsonStringToObject(responseModel.getBody(), RequestPhotoModel.class);
    }

    public static ResponseModel editPostMessage(String userId, int postId, int photoId, String text) {
        ResponseModel responseModel = APIUtils.getRequest(String.format(VkApi.WALL_EDIT.getValue(),
                userId,
                postId,
                text,
                userId,
                photoId,
                Constants.TOKEN_AND_API_VERSION));
        return responseModel;
    }

    public static ResponseModel addCommentOnPost(String userId, int postId, String message) {
        ResponseModel responseModel = APIUtils.getRequest(String.format(VkApi.WALL_CREATE_COMMENT.getValue(),
                userId,
                postId,
                message,
                Constants.TOKEN_AND_API_VERSION));
        return responseModel;
    }
}
