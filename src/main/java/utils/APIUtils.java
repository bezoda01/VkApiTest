package utils;

import api.Constants;
import models.ResponseModel;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class APIUtils {

    private static HttpClient client = HttpClientBuilder.create().build();

    public static ResponseModel getRequest(String inquiry) {
        HttpGet get = new HttpGet(Constants.environment.getConfig().getApi().getApiUrl() + inquiry);
        HttpResponse response = null;
        String body = null;
        try {
            response = client.execute(get);
            if (response.containsHeader(null)) {
                body = null;
            } else {
                body = new BasicResponseHandler().handleResponse(response);
            }
        } catch (IllegalArgumentException | IOException e) {
            e.printStackTrace();
        }

        return new ResponseModel(body, response.getStatusLine().getStatusCode());
    }

    public static ResponseModel postRequest(String inquiry, NameValuePair... params) {
        HttpPost httppost = new HttpPost(Constants.environment.getConfig().getApi() + inquiry);
        HttpResponse response = null;
        String body = null;
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        list.addAll(Arrays.asList(params));
        try {
            httppost.setEntity(new UrlEncodedFormEntity(list, "UTF-8"));
            response = client.execute(httppost);
            body = new BasicResponseHandler().handleResponse(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseModel(body, response.getStatusLine().getStatusCode());
    }

    public static ResponseModel postUploadFile(String inquiry,String subject, String pathFile) {
        HttpPost httppost = new HttpPost(inquiry);
        File fileToUse = new File(pathFile);
        FileBody data = new FileBody(fileToUse);
        httppost.addHeader(subject, String.valueOf(data));
        MultipartEntity reqEntity = new MultipartEntity();
        reqEntity.addPart(subject, data);
        httppost.setEntity(reqEntity);
        String body = null;
        HttpResponse response = null;
        try {
            response = client.execute(httppost);
            HttpEntity resEntity = response.getEntity();
            body = EntityUtils.toString(resEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseModel(body, response.getStatusLine().getStatusCode());
    }
}
