package forms;

import base.driver.BaseForm;
import base.driver.JavaScript;
import base.elements.BaseElement;
import base.elements.Button;
import base.elements.TextField;
import org.openqa.selenium.By;

public class MyPageForm extends BaseForm {

    private TextField userIdPost = null;
    private TextField userTextPost = null;
    private TextField userImgPost = null;
    private TextField userCommentOnPostId = null;
    private TextField userCommentOnPostMessage = null;
    private Button userPostLike = null;
    private String pathToCorrectPost;

    public MyPageForm(String userId, String postId) {
        super(new TextField(By.id("page_info_wrap"), "Users  page"), "Users  page");
        pathToCorrectPost = "//div[@id = 'post" + userId + "_" + postId + "']";
    }

    public String getUserIdFromNewPost() {
        userIdPost = new TextField(By.xpath(pathToCorrectPost), "Element from new post, by id user");
        return userIdPost.getTextAttribute("data-post-id");
    }

    public String getTextFromNewPost(String text) {
        userTextPost = new TextField(By.xpath(pathToCorrectPost + "//div[contains(text(),'"+text+"')]"), "Element from new post, by text message");
        return userTextPost.getText();
    }

    public String getPhotoIdFromEditPost() {
        userImgPost = new TextField(By.xpath(pathToCorrectPost+"//a[@class = 'page_post_thumb_wrap image_cover  page_post_thumb_last_column page_post_thumb_last_row']"),"Img in post");
        return userImgPost.getTextAttribute("href");
    }

    public String getIdUserInComment() {
        userCommentOnPostId = new TextField(By.xpath(pathToCorrectPost+"//div[@class='reply_text']//div[@id]"),"Comment in correct post");
        new Button(By.xpath(pathToCorrectPost+"//span[@class = 'js-replies_next_label']"),"Comment stub").focusOnElementAndClick();
        return userCommentOnPostId.getTextAttribute("id");
    }

    public String getCommentMessage() {
        userCommentOnPostMessage = new TextField(By.xpath(pathToCorrectPost+"//div[@class = 'wall_reply_text']"),"Comment message");
        return userCommentOnPostMessage.getText();
    }

    public void addLikePost() {
        userPostLike = new Button(By.xpath(pathToCorrectPost+"//div[@class = 'PostBottomActionContainer PostButtonReactionsContainer']"), "Like button");
        userPostLike.clickBtn();
    }

    public boolean checkIsPostDeleted() {
        userIdPost.isDisplayed();
        return true;
    }
}
