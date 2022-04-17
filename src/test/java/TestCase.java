import api.ApiApplication;
import api.Constants;
import base.driver.Loggerr;
import forms.AuthenticationForm;
import forms.EntireForm;
import forms.MyPageForm;
import forms.NewsForm;
import models.PostPhotoModel;
import models.PostSendModel;
import models.UploadUrlModel;
import models.postModel.PostMessageModel;
import models.requestPhotoModel.RequestPhotoModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.StringUtils;

public class TestCase extends BaseTest {

    @Test
    public void test() throws InterruptedException {
        Loggerr.getLogger().info("Open authentication page");
        AuthenticationForm authenticationForm = new AuthenticationForm();
        Assert.assertTrue(authenticationForm.isDisplayed(), "Page was not open");
        authenticationForm.clickToEntire();
        Loggerr.getLogger().info("Open entire page");
        EntireForm entireForm = new EntireForm();
        entireForm.enterAndLogin(Constants.environment.getConfig().getVkCred().getLogin(), Constants.environment.getConfig().getVkCred().getPassword());
        Loggerr.getLogger().info("Open news page");
        NewsForm newsForm = new NewsForm();
        Assert.assertTrue(newsForm.isDisplayed(), "Page was not open");
        String userId = Constants.environment.getConfig().getVkCred().getUserId();
        newsForm.goToMyPage();
        Loggerr.getLogger().info("Open user page");
        String firstText = StringUtils.randomText();
        PostSendModel postSendModel = ApiApplication.publishPost(userId, firstText);
        MyPageForm myPageForm = new MyPageForm(userId, String.valueOf(postSendModel.getResponse()));
        Assert.assertTrue(myPageForm.isDisplayed(), "Page was not open");
        Loggerr.getLogger().info("Post message on user page");
        Assert.assertTrue(myPageForm.getUserIdFromNewPost().contains(userId), "Users post do not contains correct users id");
        Assert.assertEquals(myPageForm.getTextFromNewPost(firstText), firstText, "Users post do not contains correct message");
        UploadUrlModel uploadUrlModel = ApiApplication.getUploadUrl(userId);
        PostPhotoModel postPhotoModel = ApiApplication.getPhotoAttribute(uploadUrlModel.getUpload_url());
        Loggerr.getLogger().info("Upload photo in users album");
        RequestPhotoModel requestPhotoModel = ApiApplication.savePhotoInAlbum(userId, postPhotoModel);
        String textSecond = StringUtils.randomText();
        Loggerr.getLogger().info("Edit users post");
        ApiApplication.editPostMessage(userId, postSendModel.getResponse(), requestPhotoModel.getResponse().get(0).getId(), textSecond);
        Assert.assertEquals(myPageForm.getTextFromNewPost(textSecond), textSecond);
        Assert.assertTrue(myPageForm.getPhotoIdFromEditPost().contains(String.valueOf(requestPhotoModel.getResponse().get(0).getId())));
        String textThird = StringUtils.randomText();
        ApiApplication.addCommentOnPost(userId, postSendModel.getResponse(), textThird);
        Assert.assertTrue(myPageForm.getIdUserInComment().contains(userId),"Comment was not create correct users");
        Assert.assertEquals(myPageForm.getCommentMessage(), textThird, "Comment message was not correct");
        Loggerr.getLogger().info("Add like on post");
        myPageForm.addLikePost();
        PostMessageModel postMessageModel = ApiApplication.getPostById(userId, postSendModel.getResponse());
        Assert.assertTrue(!postMessageModel.getResponse().getItems().get(0).getLikes().getUserLikes().toString().isEmpty(),"Like is not users");
        Loggerr.getLogger().info("Delete post");
        ApiApplication.deletePostById(userId, postSendModel.getResponse());
        Assert.assertTrue(myPageForm.checkIsPostDeleted(), "Post was not delete");
    }
}
