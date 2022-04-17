package api;

import models.ConfigModel;
import utils.JsonUtils;

public class Constants {
    public static ConfigModel environment = JsonUtils.jsonFileToObject("src/main/resources/config.json", ConfigModel.class);
    public static final String TOKEN_AND_API_VERSION = "&access_token=" + Constants.environment.getConfig().getApi().getToken() + "&v=" + Constants.environment.getConfig().getApi().getApiVersion();
}
