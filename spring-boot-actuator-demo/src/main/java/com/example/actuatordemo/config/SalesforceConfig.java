package com.example.actuatordemo.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Data
@ConfigurationProperties(prefix = "salesforce")
public class SalesforceConfig {

    private Access access;

    private Map<String, String> campaignIdMap;

    private Map<String, String> productsInterestedInMap;
    private String url;

    @Data
    public static class Access {
        private String grantType;
        private String secret;
    }
}
