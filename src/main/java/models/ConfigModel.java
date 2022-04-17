package models;

import lombok.Data;

@Data
public class ConfigModel {
    private Config config;

    @Data
    public class Config {
        private Browser browser;
        private Api api;
        private VkCred vkCred;

        @Data
        public class Browser {
            private String type;
            private String url;
        }

        @Data
        public class Api{
            private String apiUrl;
            private String apiVersion;
            private String token;
            private String filePath;
        }

        @Data
        public class VkCred {
            private String login;
            private String password;
            private String userId;
        }
    }

}
