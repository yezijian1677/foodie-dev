package com.imooc.resources;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author augenye
 * @date 2019/11/15 9:11 下午
 */
@Component
@ConfigurationProperties(prefix = "file")
@PropertySource("classpath:file-upload-dev.properties")
@Data
public class FileUpload {

    private String imageUserFaceLocation;
}
